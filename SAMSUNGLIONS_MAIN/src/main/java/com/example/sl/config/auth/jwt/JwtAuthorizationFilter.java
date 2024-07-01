package com.example.sl.config.auth.jwt;

import com.example.sl.repository.UserRepository;
import com.example.sl.entity.User;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public JwtAuthorizationFilter(UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("[JWTAUTHORIZATIONFILTER] doFilterInternal...");

        String token = null;
        try {
            token = Arrays.stream(request.getCookies())
                    .filter(cookie -> cookie.getName().equals(JwtProperties.COOKIE_NAME)).findFirst()
                    .map(Cookie::getValue)
                    .orElse(null);
        } catch (Exception ignored) {}

        if (token != null) {
            try {
                if (jwtTokenProvider.validateToken(token)) {
                    Authentication authentication = getUsernamePasswordAuthenticationToken(token);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    System.out.println("[JWTAUTHORIZATIONFILTER] : " + authentication);
                }
            } catch (ExpiredJwtException e) {
                System.out.println("[JWTAUTHORIZATIONFILTER] : ...ExpiredJwtException ...." + e.getMessage());
                handleTokenExpiration(request, response);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        chain.doFilter(request, response);
    }

    private Authentication getUsernamePasswordAuthenticationToken(String token) {
        Authentication authentication = jwtTokenProvider.getAuthentication(token);
        Optional<User> user = userRepository.findByUserName(authentication.getName());
        System.out.println("JwtAuthorizationFilter.getUsernamePasswordAuthenticationToken...authenticationToken : " + authentication);
        return user.map(u -> authentication).orElse(null);
    }

    private void handleTokenExpiration(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie refreshTokenCookie = Arrays.stream(request.getCookies())
                .filter(cookie -> cookie.getName().equals(JwtProperties.REFRESH_COOKIE_NAME)).findFirst()
                .orElse(null);

        if (refreshTokenCookie != null) {
            String refreshToken = refreshTokenCookie.getValue();
            if (jwtTokenProvider.validateRefreshToken(refreshToken)) {
                String newAccessToken = jwtTokenProvider.generateAccessTokenFromRefreshToken(refreshToken);
                response.setHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + newAccessToken);
            } else {
                Cookie cookie = new Cookie(JwtProperties.REFRESH_COOKIE_NAME, null);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }
}

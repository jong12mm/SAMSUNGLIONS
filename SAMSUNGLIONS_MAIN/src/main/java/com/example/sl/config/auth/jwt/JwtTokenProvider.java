package com.example.sl.config.auth.jwt;

import com.example.sl.config.PrincipalDetails;
import com.example.sl.domain.dto.OAuthUserDto;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtTokenProvider {

    String url = "jdbc:mysql://localhost:3306/samsungdb";
    String username = "root";
    String password = "1234";
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;

    private final Key key;

    public JwtTokenProvider() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, username, password);
        pstmt = conn.prepareStatement("select * from signature");
        rs = pstmt.executeQuery();

        if (rs.next()) {
            byte[] keyBytes = rs.getBytes("signkey");
            this.key = Keys.hmacShaKeyFor(keyBytes);
        } else {
            byte[] keyBytes = KeyGenerator.getKeygen();
            this.key = Keys.hmacShaKeyFor(keyBytes);
            pstmt = conn.prepareStatement("insert into signature values(?, now())");
            pstmt.setBytes(1, keyBytes);
            pstmt.execute();
        }
        System.out.println("JwtTokenProvider Constructor Key init: " + key);
    }

    public TokenInfo generateToken(Authentication authentication) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        long now = (new Date()).getTime();

        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        OAuthUserDto oauserDto = principalDetails.getOauserDto();
        Date accessTokenExpiresIn = new Date(now + 60 * 1000); // 60초 후 만료
        String accessToken = Jwts.builder()
                .setSubject(authentication.getName())
                .claim("userName", authentication.getName())
                .claim("password", oauserDto.getPassword())
                .claim("auth", authorities)
                .claim("principal", authentication.getPrincipal())
                .claim("credentials", authentication.getCredentials())
                .claim("details", authentication.getDetails())
                .claim("provider", oauserDto.getProvider())
                .claim("accessToken", principalDetails.getAccessToken())
                .setExpiration(accessTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        String refreshToken = generateRefreshToken(authentication.getName());

        System.out.println("JwtTokenProvider.generateToken.accessToken : " + accessToken);
        System.out.println("JwtTokenProvider.generateToken.refreshToken : " + refreshToken);

        return TokenInfo.builder()
                .grantType("Bearer")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    private String generateRefreshToken(String username) {
        long now = System.currentTimeMillis();
        Date refreshTokenExpiresIn = new Date(now + 24 * 60 * 60 * 1000); // 1일 후 만료

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(refreshTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public Authentication getAuthentication(String accessToken) {
        Claims claims = parseClaims(accessToken);

        if (claims.get("auth") == null) {
            throw new RuntimeException("권한 정보가 없는 토큰입니다.");
        }

        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get("auth").toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        String username = claims.getSubject();

        String provider = (String) claims.get("provider");
        String password = (String) claims.get("password");
        String auth = (String) claims.get("auth");
        String oauthAccessToken = (String) claims.get("accessToken");
        OAuthUserDto oauserDto = new OAuthUserDto();
        oauserDto.setProvider(provider);
        oauserDto.setUsername(username);
        oauserDto.setPassword(password);
        oauserDto.setRole(auth);

        PrincipalDetails principalDetails = new PrincipalDetails(oauserDto);
        principalDetails.setAccessToken(oauthAccessToken);

        return new UsernamePasswordAuthenticationToken(principalDetails, claims.get("credentials"), authorities);
    }

    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("Invalid JWT Token", e);
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT Token", e);
        } catch (IllegalArgumentException e) {
            log.info("JWT claims string is empty.", e);
        }
        return false;
    }

    public boolean validateRefreshToken(String refreshToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(refreshToken);
            return true;
        } catch (ExpiredJwtException e) {
            log.info("Expired Refresh Token", e);
        } catch (JwtException | IllegalArgumentException e) {
            log.info("Invalid Refresh Token", e);
        }
        return false;
    }

    public String generateAccessTokenFromRefreshToken(String refreshToken) {
        Claims claims = parseClaims(refreshToken);
        String username = claims.getSubject();
        Date accessTokenExpiresIn = new Date(System.currentTimeMillis() + 60 * 1000); // 60초 후 만료
        return Jwts.builder()
                .setSubject(username)
                .claim("userName", username)
                .setExpiration(accessTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}

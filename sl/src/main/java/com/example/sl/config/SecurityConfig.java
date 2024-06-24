package com.example.sl.config;


import com.example.sl.config.auth.exceptionHandler.CustomAccessDeniedHandler;
import com.example.sl.config.auth.exceptionHandler.CustomAuthenticationEntryPoint;
import com.example.sl.config.auth.jwt.JwtAuthorizationFilter;
import com.example.sl.config.auth.jwt.JwtProperties;
import com.example.sl.config.auth.jwt.JwtTokenProvider;
import com.example.sl.config.auth.loginHandler.CustomAuthenticationFailureHandler;
import com.example.sl.config.auth.loginHandler.CustomLoginSuccessHandler;
import com.example.sl.config.auth.loginHandler.OAuth2JwtLoginSuccessHandler;
import com.example.sl.config.auth.logoutHandler.CustomLogoutHandler;
import com.example.sl.config.auth.logoutHandler.CustomLogoutSuccessHandler;
import com.example.sl.config.auth.logoutHandler.SessionCookieClearingLogoutHandler;
import com.example.sl.domain.repository.UserRepository;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Autowired
    private HikariDataSource dataSource;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;




    //웹요청 처리
    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {

        //CSRF 비활성화
        http.csrf((config)->{config.disable();});



        //요청 URL별 접근 제한
        http.authorizeHttpRequests((auth)->{
//            auth.requestMatchers("/favicon.ico").permitAll();
            auth.requestMatchers("/admin").hasRole("ADMIN");
            auth.requestMatchers("/book/**","/book_start","/booklist").hasRole("USER");
            auth.requestMatchers("/samsung","/user/adult_join","/user/child_join","/user/join_start","/user/join_finish","/user/login","/**").permitAll();

            auth.anyRequest().authenticated();
        });

        //로그인
        http.formLogin((login)->{
            login.permitAll();
            login.loginPage("/user/login");
            login.successHandler(new CustomLoginSuccessHandler(jwtTokenProvider));
            login.failureHandler(new CustomAuthenticationFailureHandler());
        });

        //로그아웃
        http.logout((logout)->{
            logout.permitAll();
            logout.logoutUrl("/user/logout");
            logout.addLogoutHandler(customLogoutHandler());
//            logout.addLogoutHandler(sessionCookieClearingLogoutHandler());
            logout.logoutSuccessHandler(customLogoutSuccessHandler());
            //JWT
            logout.deleteCookies("JSESSIONID", JwtProperties.COOKIE_NAME);
            logout.invalidateHttpSession(true);
        });

        //예외처리
        http.exceptionHandling((ex)->{
            ex.accessDeniedHandler(new CustomAccessDeniedHandler());
            ex.authenticationEntryPoint(new CustomAuthenticationEntryPoint());
        });

        //REMEMBER_ME
        http.rememberMe((rm)->{
            rm.key("rememberMeKey");
            rm.rememberMeParameter("remember-me");
            rm.tokenValiditySeconds(60*60*24*7);
            rm.tokenRepository(tokenRepository());
            rm.alwaysRemember(false);

        });

        //OAUTH2-CLIENT
        http.oauth2Login((oauth2)->{
            oauth2.loginPage("/user/login");
            oauth2.successHandler(new OAuth2JwtLoginSuccessHandler(jwtTokenProvider));

        });

        //SESSION INVALIDATE..
        http.sessionManagement(
                httpSecuritySessionManagementConfigurer ->
                        httpSecuritySessionManagementConfigurer.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
        );

        //JWT FILTER ADDED
        http.addFilterBefore(new JwtAuthorizationFilter(userRepository,jwtTokenProvider),
                BasicAuthenticationFilter.class);

        return http.build();
    }





    @Bean
    public PersistentTokenRepository tokenRepository(){
        JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
        repo.setDataSource(dataSource);
        return repo;
    }







//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        userDetailsManager
//                    .createUser(User
//                            .withUsername("user")
//                            .password(passwordEncoder.encode("1234"))
//                            .roles("USER")
//                            .build()
//                    );
//        userDetailsManager
//                .createUser(User
//                        .withUsername("member")
//                        .password(passwordEncoder.encode("1234"))
//                        .roles("MEMBER")
//                        .build()
//                );
//        userDetailsManager
//                .createUser(User
//                        .withUsername("admin")
//                        .password(passwordEncoder.encode("1234"))
//                        .roles("ADMIN")
//                        .build()
//                );
//        return userDetailsManager;
//    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public CustomLogoutHandler customLogoutHandler(){
        return new CustomLogoutHandler();
    }
    @Bean
    public CustomLogoutSuccessHandler customLogoutSuccessHandler(){
        return new CustomLogoutSuccessHandler();
    }


}
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private String secretKey;
//
//    public SecurityConfig(UserService userService,@Value("${jwt.secret}") String secretKey) {
//        this.userService = userService;
//        this.secretKey = secretKey;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .httpBasic(httpBasic -> httpBasic.disable())
//                .csrf(csrf -> csrf.disable())
//                .cors(cors -> cors.configure(http))
//                .authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers("/book/**").authenticated()
//                                .anyRequest().permitAll()
//                )
//                .sessionManagement(sessionManagement ->
//                        sessionManagement
//                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                )
//                .addFilterBefore(new JwtFilter(userService, secretKey), UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//}

package com.edw.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

import java.io.IOException;

/**
 * <pre>
 *     com.edw.config.SecurityConfiguration
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 21 Mar 2023 20:16
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

   /* @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .oauth2Client()
                    .and()
                .oauth2Login()
                .tokenEndpoint()
                    .and()
                .userInfoEndpoint();

        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);

        http
                .authorizeHttpRequests()
                            .requestMatchers("/unauthenticated", "/oauth2/**", "/login/**").permitAll()
                            .anyRequest()
                                .fullyAuthenticated()
                .and()
                    .logout()
                    .logoutSuccessUrl("http://localhost:8080/realms/external/protocol/openid-connect/logout?redirect_uri=http://localhost:8081/");

        return http.build();
    }*/

    private static Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(new LoggingFilter(), SecurityContextPersistenceFilter.class) // 添加拦截器在Spring Security过滤器链之前
                // 其他安全配置...
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/public/**") // 为特定URL禁用CSRF保护
                )
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/public/**").permitAll() // 放行公开的链接
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                                .jwt(jwt -> jwt
//                            .decoder(jwtDecoder())
                                                .jwtAuthenticationConverter(jwtAuthenticationConverter())
                                )
                )
                // 使用新的配置器替代 exceptionHandling()
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .authenticationEntryPoint(new CustomBearerTokenAuthenticationEntryPoint())
                        .accessDeniedHandler(new CustomAccessDeniedHandler())
                );


        return http.build();
    }

//    @Bean
//    public JwtDecoder jwtDecoder() {
//        // 配置 JWT 解码器
//        return JwtDecoders.fromIssuerLocation("http://127.0.0.1:8080/realms/user_login");
//    }

    // 自定义访问被拒绝处理器
    private JwtAuthenticationConverter jwtAuthenticationConverter() {
        System.out.println("被拒绝处理器");
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(new JwtGrantedAuthoritiesConverter());
        return converter;
    }

    // 自定义访问被拒绝处理器
    private static class CustomBearerTokenAuthenticationEntryPoint implements AuthenticationEntryPoint {
        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.AuthenticationException authException) throws IOException {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write("{\"code\": 401, \"error\": \"Unauthorized\", \"message\": \"JWT token is invalid or expired\"}");
        }
    }

    // 自定义访问被拒绝处理器
    private static class CustomAccessDeniedHandler implements AccessDeniedHandler {
        @Override
        public void handle(HttpServletRequest request, HttpServletResponse response, org.springframework.security.access.AccessDeniedException accessDeniedException) throws IOException {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write("{\"code\": 401, \"error\": \"Forbidden\", \"message\": \"Access denied due to invalid credentials\"}");
        }
    }

}

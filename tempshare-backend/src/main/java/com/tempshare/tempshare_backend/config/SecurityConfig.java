package com.tempshare.tempshare_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // config file
@EnableWebSecurity // enables custom sprin security config
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .cors(cors -> {}) // Allow CORS and do NOT block controller-level @CrossOrigin rules.
                //Spring Security blocks POST requests without CSRF token.
                //My frontend doesn’t send CSRF token, so disable it temporarily.

                .authorizeHttpRequests(auth->auth.anyRequest().permitAll());
                // this allows /auth/signup/ or /login without needing authentication
        return http.build();
    }
}

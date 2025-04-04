package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // Disable CSRF for simplicity during development
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/admins/register").permitAll() // Allow public access to this endpoint
                        .requestMatchers("/api/admins/login").permitAll()
                        .anyRequest().authenticated()); // Secure other endpoints
        return http.build();
    }
}

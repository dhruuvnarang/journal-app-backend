package com.spring.journalApp.config;

import com.spring.journalApp.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    private final UserDetailsServiceImpl userDetailsService;

    public SpringSecurity(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Updated configuration for HTTP security
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll()  // Public endpoints
                        .requestMatchers("/journal/**", "/user/**").authenticated()  // Authenticated endpoints
                        .anyRequest().authenticated())  // Any other request requires authentication
                .httpBasic(withDefaults())  // Correct way to configure HTTP Basic
                .csrf(csrf -> csrf.disable());  // Disable CSRF protection for simplicity

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

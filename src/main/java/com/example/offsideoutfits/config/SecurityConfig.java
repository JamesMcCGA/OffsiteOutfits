package com.example.offsideoutfits.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build());
        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers(HttpMethod.OPTIONS, "/error").permitAll()
                        .requestMatchers(HttpMethod.POST, "/shoppers").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/instances").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/shoppers").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/Players").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/Teams").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/TShirts").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/TShirtsByUsername").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/actuator/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/applications").hasRole("USER")
                        .anyRequest().authenticated())
                .httpBasic(withDefaults())
                .csrf(csrf -> csrf.disable());
        return http.build();
    }



}


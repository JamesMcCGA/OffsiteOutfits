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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

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
                        .requestMatchers(HttpMethod.GET, "/TShirtsByEmail").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/actuator/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/applications").hasRole("USER")
                        .anyRequest().authenticated())
                .httpBasic(withDefaults())
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(csrf -> csrf.disable());
        return http.build();
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("http://127.0.0.1:5500")); // or use Arrays.asList() for multiple origins
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:5500"); // Allow frontend server
        config.addAllowedHeader("*");
        config.addAllowedMethod("*"); // You can list specific methods like "GET", "POST", etc.
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }



}


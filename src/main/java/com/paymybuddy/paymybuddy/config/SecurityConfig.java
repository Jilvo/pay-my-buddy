package com.paymybuddy.paymybuddy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
        // @Bean
        // public PasswordEncoder passwordEncoder() {
        // return new BCryptPasswordEncoder();
        // }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http
                                .csrf().disable() // Désactiver CSRF
                                .authorizeRequests()
                                .requestMatchers("/", "/signup", "/login", "/perform_signup", "/perform_login")
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                                .and()
                                .formLogin()

                                .loginPage("/login") // Utiliser votre page de connexion personnalisée

                                .defaultSuccessUrl("/transfer", true)
                                .permitAll()
                                .and()
                                .logout()
                                .permitAll();

                return http.build();
        }

        @SuppressWarnings("deprecation")
        @Bean
        public NoOpPasswordEncoder passwordEncoder() {
                return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
        }
}

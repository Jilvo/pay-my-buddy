package com.paymybuddy.paymybuddy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http
                                .csrf(csrf -> csrf.disable()) // Désactiver CSRF
                                .authorizeRequests(authorizeRequests -> authorizeRequests
                                                .requestMatchers("/styles/**", "/pics/**").permitAll()
                                                .requestMatchers("/").permitAll()
                                                .requestMatchers("/register").permitAll()
                                                .requestMatchers("/error").permitAll()

                                                .dispatcherTypeMatchers(HttpMethod.valueOf("/login")).permitAll() // Permet
                                                                                                                  // à
                                                                                                                  // tout
                                                                                                                  // le
                                                                                                                  // monde
                                                                                                                  // d'accéder
                                                                                                                  // à
                                                                                                                  // /login

                                                .anyRequest().authenticated() // Toutes les autres requêtes nécessitent
                                                                              // une authentification
                                )
                                .formLogin(formLogin -> formLogin.loginPage("/login") // Utiliser votre page de
                                                                                      // connexion personnalisée
                                                .loginProcessingUrl("/perform_login") // Endpoint qui traitera le
                                                                                      // formulaire de connexion
                                                .defaultSuccessUrl("/", true) // Rediriger vers cette page en cas de
                                                                              // succès
                                                // .usernameParameter("email") // Set the username parameter
                                                .permitAll())
                                .logout(logout -> logout.permitAll());
                return http.build();
        }
}

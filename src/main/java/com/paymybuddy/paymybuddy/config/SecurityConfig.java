package com.paymybuddy.paymybuddy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Bean
        public DaoAuthenticationProvider authenticationProvider(UserDetailsManager userDetailsManager,
                        PasswordEncoder passwordEncoder) {
                DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
                System.out.println("userDetailsManager: " + userDetailsManager);
                authProvider.setUserDetailsService(userDetailsManager);
                authProvider.setPasswordEncoder(passwordEncoder);
                return authProvider;
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth, DaoAuthenticationProvider authenticationProvider)
                        throws Exception {
                auth.authenticationProvider(authenticationProvider);
        }

        @Bean
        SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests((authorize) -> authorize
                                                .requestMatchers("/css/**", "/favicon.ico", "/", "/index", "/signup",
                                                                "/login", "/perform_login",
                                                                "/perform_signup")
                                                .permitAll()
                                                .requestMatchers("/user").hasAnyRole("USER")
                                                .requestMatchers("/admin").hasAnyRole("ADMIN")
                                                .anyRequest().authenticated())
                                .formLogin(login -> login
                                                // .loginPage("/login")
                                                .defaultSuccessUrl("/transfer")
                                                .permitAll())
                                .logout(logout -> logout
                                                .logoutSuccessUrl("/"));
                return http.build();
        }

        @Bean
        PasswordEncoder passwordEncoder() {
                return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        }

        @Bean
        UserDetailsManager inMemoryUserDetailsManager() {
                var user1 = User.withUsername("john.doe@example.com").password("{noop}password1").roles("USER").build();
                var user2 = User.withUsername("jane.doe@example.com").password("{noop}password2").roles("USER", "ADMIN")
                                .build();
                var user3 = User.withUsername("jean.valjean@example.com").password("{noop}password3").roles("USER")
                                .build();
                var user4 = User.withUsername("test@gmail.com").password("{noop}123").roles("USER").build();
                return new InMemoryUserDetailsManager(user1, user2, user3, user4);
        }

}

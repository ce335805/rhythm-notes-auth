package com.rhythmnotes.security.authentication.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;


@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/auth/**")
                .permitAll()
                .anyRequest()
                .authenticated())
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    //@Bean
    //public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
    //    http.csrf()
    //            .disable()
    //            .authorizeHttpRequests()
    //            .requestMatchers("/auth/**")
    //            .permitAll()
    //            .anyRequest()
    //            .authenticated();
//
    //    return http.build();
    //}

}

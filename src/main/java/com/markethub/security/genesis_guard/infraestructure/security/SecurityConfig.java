package com.markethub.security.genesis_guard.infraestructure.security;

import com.markethub.security.genesis_guard.infraestructure.security.constants.ConstantsSecurity;
import com.markethub.security.genesis_guard.infraestructure.security.filter.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    private final AuthenticationManager authenticationManager;

    private final ConstantsSecurity constantsSecurity;

    public SecurityConfig(AuthenticationManager authenticationManager, ConstantsSecurity constantsSecurity){
        this.authenticationManager = authenticationManager;
        this.constantsSecurity = constantsSecurity;
    }


    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((request)->{
                    request.requestMatchers("/user/**").permitAll();
                    request.requestMatchers("/user/register").permitAll();
                    request.requestMatchers("/product/**").permitAll();
                    request.requestMatchers("/publication/**").permitAll();
                    request.requestMatchers("/images/**").permitAll();
                    request.requestMatchers("/transaction/**").permitAll();
                    request.requestMatchers("/offer/**").permitAll();
                    request.requestMatchers("/transaction/**").permitAll();
                    request.requestMatchers("/denuciations/**").permitAll();
                    request.requestMatchers("/counter-offer/**").permitAll();
                    request.requestMatchers("/commentary/**").permitAll();
                    request.requestMatchers("/comments-publication/**").permitAll();
                    request.requestMatchers("/security/**").permitAll()
                    .anyRequest().authenticated();
                })
                .sessionManagement(management-> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilter(new JwtAuthenticationFilter(authenticationManager,constantsSecurity))
                .addFilter(new JwtRequestFilter(authenticationManager,constantsSecurity));

        return httpSecurity.build();
    }


}

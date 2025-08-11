package com.simplefinancialadvisor.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for Spring Security.
 * This class defines the SecurityFilterChain bean to provide custom security configurations.
 */

@Configuration
public class SecurityConfig {

	/**
     * Defines the security filter chain.
     *
     * @param http the HttpSecurity object to configure.
     * @return the SecurityFilterChain bean.
     * @throws Exception if an error occurs during configuration.
     */
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable);
		http.authorizeHttpRequests( authorizationManagerRequestMatcherRegistry -> {
			authorizationManagerRequestMatcherRegistry
			.requestMatchers("\"/actuator/**\"").permitAll()
			.anyRequest()
			.authenticated();
		});
		return http.build();
	}
}

package com.example.springsecuritysection4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
		
		http.csrf((csrf) -> csrf.disable())
		.authorizeHttpRequests(configurer->
			configurer
				.requestMatchers("/myAccount", "myBalance", "/myCards", "/myLoans").authenticated()
				.requestMatchers("/notices", "/contacts", "/register", "/error").permitAll()
				)
		
		.formLogin(Customizer.withDefaults())
		
		.httpBasic(Customizer.withDefaults());		
		
		return http.build();
	}
	
	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

package com.qlns.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@ComponentScan("com.qlns.config")
public class WebSecurityConfigureAdapter {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {		
		http.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/", "/welcome", "/login", "/checkLogin", "/error"
						, "/resources/**", "/WEB-INF/jsp/**", "/register")
				.permitAll()
				.anyRequest().authenticated()
		);
		
		http.formLogin(authorize -> authorize
				.loginPage("/login").permitAll()
				.defaultSuccessUrl("/").permitAll()
		);
		
		http.logout(config -> config
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
		);
				
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

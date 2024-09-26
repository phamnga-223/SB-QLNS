package com.qlns.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@ComponentScan("com.qlns.config")
public class WebSecurityConfig implements WebMvcConfigurer {
	
	@Bean
	public UserDetailsService userDetailsService() { 
		UserDetails admin = User.builder()
				.username("username")
				.password(passwordEncoder().encode("password"))
				.roles("USER", "ADMIN")
				.build();
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(admin);
		
		return manager;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.requestMatchers("/login").permitAll()
			.requestMatchers("/**").authenticated()
			.and()
			.formLogin().permitAll();
		
		return http.build();
	}
}

package com.qlns.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.qlns.model.Admin;
import com.qlns.service.AdminService;

@Component
public class AuthProvider implements AuthenticationProvider {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AdminService adminService;
	
	private static UsernamePasswordAuthenticationToken authenticateAgainstThirdPartyAndGetAuthentication (String name, String password) {
		final List<GrantedAuthority> grantedAuths = new ArrayList<>();
		grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		final UserDetails principal = new User(name, password, grantedAuths);
		
		return new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		UserDetails admin = adminService.loadUserByUsername(username);
		String adminPassword = admin.getPassword();
		if (passwordEncoder.matches(password, adminPassword)) {
			return authenticateAgainstThirdPartyAndGetAuthentication(username, password);
		} else {
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}

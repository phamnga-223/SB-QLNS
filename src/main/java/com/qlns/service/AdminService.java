package com.qlns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.qlns.model.Admin;
import com.qlns.model.CustomUserDetails;
import com.qlns.repository.AdminRepository;

@Service
public class AdminService implements UserDetailsService {

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	public String checkAdmin(Admin admin) {
		String result;
		
		try {
			Admin adminCheck = adminRepository.getAdmin(admin.getUsername(), admin.getPassword());
			if (adminCheck == null) {
				return "UNSUCCESS";
			}
			
			result = "SUCCESS";
		} catch (Exception ex) {
			System.out.println("Error!");
			ex.printStackTrace();
			result = "UNSUCCESS";
		}
		
		return result;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminRepository.getAdmin(username);
		if (admin == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		return new CustomUserDetails(admin);
	}
	
	public String register(Admin admin) {
		String result;
		
		try {
			if (accountExists(admin.getUsername())) {
				throw new Exception("Account's already exists! - " + admin.getUsername());
			}
			
			admin.setPassword(encoder.encode(admin.getPassword()));
			admin.setMatchingPassword(admin.getPassword());
			admin = adminRepository.save(admin);
			
			result = "SUCCESS";
		} catch (Exception ex) {
			System.err.println("Error!");
			ex.printStackTrace();
			result = "UNSUCCESS";
		}
		
		return result;
	}
	
	public boolean accountExists(String username) {
		Admin admin = adminRepository.getAdmin(username);
		
		return (admin != null);
	}
}

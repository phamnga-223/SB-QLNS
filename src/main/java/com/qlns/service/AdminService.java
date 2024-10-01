package com.qlns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.qlns.model.Admin;
import com.qlns.model.CustomUserDetails;
import com.qlns.repository.AdminRepository;

@Service
public class AdminService implements UserDetailsService {

	@Autowired
	AdminRepository adminRepository;
	
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
}

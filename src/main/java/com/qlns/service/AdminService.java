package com.qlns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlns.model.Admin;
import com.qlns.repository.AdminRepository;

@Service
public class AdminService {

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
}

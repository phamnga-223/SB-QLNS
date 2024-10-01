package com.qlns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qlns.model.Admin;
import com.qlns.service.AdminService;

import jakarta.validation.Valid;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("admin", new Admin());
		
		return "common/pages/login";
	}

	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public String login(Model model, @ModelAttribute("admin") @Valid Admin admin,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "common/pages/login";
		}
		
		String result = adminService.checkAdmin(admin);
		if (result == "SUCCESS") {	
			model.addAttribute("active", "welcome");
			return "redirect:/welcome";
		} else {
			return "common/pages/login";
		}
	}
}

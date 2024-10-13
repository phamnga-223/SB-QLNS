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

import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("admin", new Admin());
		
		return "common/pages/login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("admin", new Admin());
		
		return "common/pages/register";
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public String register(Model model, @ModelAttribute("admin") @Valid Admin admin
		, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return register(model);
		}
		
		String result = adminService.register(admin);
		if (!result.equals("SUCCESS")) {
			return register(model);
		}
		
		return "common/pages/welcome";
	}
	
}

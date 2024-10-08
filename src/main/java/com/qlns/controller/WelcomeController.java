package com.qlns.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	@RequestMapping(value={"/welcome", "/"}, method=RequestMethod.GET)
	public String hello(Model model) {
		model.addAttribute("active", "welcome");
		
		return "common/pages/welcome";
	}
	
}

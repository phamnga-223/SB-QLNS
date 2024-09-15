package com.qlns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qlns.model.Company;
import com.qlns.service.CompanyService;

@Controller
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	@RequestMapping(value = "/company", method = RequestMethod.GET)
	public String company(Model model) {						
		List<Company> listCompany = companyService.listCompany();
		model.addAttribute("listCompany", listCompany);
		
		return "company/company";
	}
}

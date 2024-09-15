package com.qlns.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlns.model.Company;
import com.qlns.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;
	
	public List<Company> listCompany() {		
		List<Company> list = new ArrayList<Company>();
		companyRepository.findAll().forEach(company -> list.add(company));
		
		return list;
	}

}

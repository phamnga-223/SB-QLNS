package com.qlns.repository;

import org.springframework.data.repository.CrudRepository;

import com.qlns.model.Company;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
	
}

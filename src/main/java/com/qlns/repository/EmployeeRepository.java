package com.qlns.repository;

import org.springframework.data.repository.CrudRepository;

import com.qlns.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}

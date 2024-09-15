package com.qlns.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qlns.model.Employee;
import com.qlns.repository.EmployeeRepository;

@Repository
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee findEmployee(int id) {		
		if (id < 0)
			return null;

		Employee e = employeeRepository.findById(id).get();
		
		return e;
	}
	
	public static void swap (List<Employee> list, int i, int j) {
		Employee e = list.get(i);
		list.set(i, list.get(j));
		list.set(j, e);
	}

	public String addEmployee(Employee employee) {
		String result;
		
		try {
			employeeRepository.save(employee);
			result = "SUCCESS";
		} catch (Exception ex) {
			System.out.println("Error!");
			ex.printStackTrace();
			
			result = "UNSUCCESS";
		}

		return result;
	}

	public List<Employee> listEmployee() {
		List<Employee> listEmployee = new ArrayList<>();
		employeeRepository.findAll().forEach(employee -> listEmployee.add(employee));
		
		return listEmployee;
	}

	public String updateEmployee(int id, Employee employee) {
		String result = "";
		
		try {
			// Check id
			if (id < 0) {
				return "UNSUCCESS";
			}
			
			employeeRepository.save(employee);
			result = "SUCCESS";
		} catch (Exception ex) {
			System.out.println("Error!");
			ex.printStackTrace();
			
			result = "UNSUCCESS";
		}
		
		return result;
	}
}

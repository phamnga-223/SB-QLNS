package com.qlns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qlns.model.Employee;
import com.qlns.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String employee(Model model) {
		List<Employee> listEmployee = employeeService.listEmployee();
		
		model.addAttribute("listEmployee", listEmployee);
		
		return "employee/employee";
	}
	
	@RequestMapping(value = "/employee/add", method = RequestMethod.GET)
	public String addEmployee(Model model) {
		
		return "employee/addEmployee";
	}
	
	@RequestMapping(value = "/employee/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String addEmployee(Model model, Employee employee) {
		String result = employeeService.addEmployee(employee);
		
		model.addAttribute("result", result);
		
		return employee(model);
	}
	
	@RequestMapping(value = "/employee/update", method = RequestMethod.GET)
	public String updateEmployee(Model model, @RequestParam("id") int id) {
		Employee e = employeeService.findEmployee(id);
		if (e == null)
			return "employee/employee";
		
		long salaryPerDay = e.getSalaryPerDay();
		String employeeType = "";
		if (salaryPerDay == Employee.SALARY_P_DAY_EMPLOYEE) {
			employeeType = Employee.TYPE_EMPLOYEE;
		} else if (salaryPerDay == Employee.SALARY_P_DAY_MANAGER) {
			employeeType = Employee.TYPE_DEPARTMENT_MANAGER;
		} else if (salaryPerDay == Employee.SALARY_P_DAY_DIRECTOR) {
			employeeType = Employee.TYPE_DIRECTOR;
		}
		
		model.addAttribute("e", e);
		model.addAttribute("employeeType", employeeType);
		
		return "employee/updateEmployee";
	}
	
	@RequestMapping(value = "/employee/update", method = RequestMethod.POST)
	public String updateEmployee(Model model, @RequestParam("id") int id, Employee employee) {
		
		
		String result = employeeService.updateEmployee(id, employee);
		model.addAttribute("result", result);
		
		return employee(model);
	}
	
	@RequestMapping(value = "/employee/delete", method = RequestMethod.DELETE)
	public String deleteEmployee(Model model) {
		return "";
	}
}

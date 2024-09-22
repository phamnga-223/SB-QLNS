package com.qlns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qlns.model.Employee;
import com.qlns.service.EmployeeService;

import jakarta.validation.Valid;

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
		
		model.addAttribute("employee", new Employee());
		return "employee/addEmployee";
	}
	
	@RequestMapping(value = "/employee/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String addEmployee(Model model, @ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "employee/addEmployee";
		
		String result = employeeService.addEmployee(employee);
		
		model.addAttribute("result", result);
		
		return employee(model);		
	}
	
	@RequestMapping(value = "/employee/update", method = RequestMethod.GET)
	public String updateEmployee(Model model, @RequestParam("id") int id) {
		Employee e = employeeService.findEmployee(id);
		if (e == null)
			return "employee/employee";	
		
		model.addAttribute("e", e);
		
		return "employee/updateEmployee";
	}
	
	@RequestMapping(value = "/employee/update", method = RequestMethod.POST)
	public String updateEmployee(Model model, @RequestParam("id") int id, @ModelAttribute("e") @Valid Employee employee,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "employee/updateEmployee";
		
		String result = employeeService.updateEmployee(id, employee);
		model.addAttribute("result", result);
		
		return employee(model);
	}
	
	@ResponseBody
	@RequestMapping(value = "/employee/delete", method = RequestMethod.DELETE)
	public String deleteEmployee(Model model, @RequestParam("id") int id) {
		String result = employeeService.deleteEmployee(id);
		model.addAttribute("result", result);

		return result;
	}
}

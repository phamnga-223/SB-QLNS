package com.qlns.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qlns.model.EmployeeSalary;
import com.qlns.service.EmployeeSalaryService;

@Controller
public class EmployeeSalaryController {
	
	@Autowired
	private EmployeeSalaryService employeeSalaryService;
	
	@ResponseBody
	@RequestMapping(value = "/employee-salary", method=RequestMethod.GET)
	public EmployeeSalary calculateSalary(Model model, @RequestParam("employeeId") int employeeId) {
		EmployeeSalary entity = employeeSalaryService.getEmployeeSalary(employeeId);
		model.addAttribute("employeeSalary", entity);
		
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value = "/employee-salary", method = RequestMethod.POST)
	public EmployeeSalary calculateSalary(Model model, @RequestBody Map<String, Object> data) {
		
		try {
			Map<String, Object> employeeSalaryMap = (Map<String, Object>) data.get("employeeSalary");
			EmployeeSalary employeeSalary = new EmployeeSalary();
			employeeSalary.setId(Integer.parseInt((String)employeeSalaryMap.get("id")));
			employeeSalary.setEmployeeId(Integer.parseInt((String)employeeSalaryMap.get("employeeId")));
			employeeSalary.setMonth(Integer.parseInt((String)employeeSalaryMap.get("month")));
			employeeSalary.setWorkDay(Integer.parseInt((String)employeeSalaryMap.get("workDay")));
			employeeSalary.setStatus((String)employeeSalaryMap.get("status"));
			employeeSalary.setNote((String)employeeSalaryMap.get("note"));
	
			employeeSalary = employeeSalaryService.calculateSalary(employeeSalary);
			
			return employeeSalary;
		} catch (Exception ex) {
			System.err.println("Error!");
			ex.printStackTrace();
			
			return null;
		}		
	}

	@ResponseBody
	@RequestMapping(value = "/employee-salary/save", method = RequestMethod.POST)
	public EmployeeSalary saveSalary(@RequestBody Map<String, Object> data) {
		EmployeeSalary employeeSalary = new EmployeeSalary();
		
		try {
			Map<String, Object> employeeSalaryMap = (Map<String, Object>) data.get("employeeSalary");
			employeeSalary.setId(Integer.parseInt((String)employeeSalaryMap.get("id")));
			employeeSalary.setEmployeeId(Integer.parseInt((String)employeeSalaryMap.get("employeeId")));
			employeeSalary.setMonth(Integer.parseInt((String)employeeSalaryMap.get("month")));
			employeeSalary.setWorkDay(Integer.parseInt((String)employeeSalaryMap.get("workDay")));
			employeeSalary.setStatus((String)employeeSalaryMap.get("status"));
			employeeSalary.setNote((String)employeeSalaryMap.get("note"));
			employeeSalary.setAllowance(Integer.parseInt((String)employeeSalaryMap.get("allowance")));
			employeeSalary.setInsurance(Integer.parseInt((String)employeeSalaryMap.get("insurance")));
			employeeSalary.setSalary(Integer.parseInt((String)employeeSalaryMap.get("salary")));
			
			employeeSalary = employeeSalaryService.saveSalary(employeeSalary);
		} catch (Exception ex) {
			System.out.println("Error!");
			ex.printStackTrace();			
		}
		
		return employeeSalary;
	}
	
	@ResponseBody
	@RequestMapping(value = "/employee-salary/export", method=RequestMethod.POST)
	public String exportSalaryDividual(@RequestParam("id") int id) {
		if (id == 0) {
			return "";
		}
	
		String result = employeeSalaryService.exportSalaryDividual(id);
		
		return result;
	}

}

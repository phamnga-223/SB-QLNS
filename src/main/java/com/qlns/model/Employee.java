package com.qlns.model;

import java.util.List;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table
public class Employee {
	
	public static final int SALARY_P_DAY_EMPLOYEE = 100000;
	public static final int SALARY_P_DAY_MANAGER = 200000;
	public static final int SALARY_P_DAY_DIRECTOR = 300000;

	public static final String TYPE_EMPLOYEE = "Employee";
	public static final String TYPE_DEPARTMENT_MANAGER = "Department Manager";
	public static final String TYPE_DIRECTOR = "Director";
		
	@Id
	@Column
	private int id;
	@Column
	@NotBlank(message = "Name is mandatory")
	private String name;
	@Column
	private String phone;
	@Column
	@Min(value = 0, message = "Salary Per Day is greater than 0")
	private int salaryPerDay;
	@Column
	@Nullable
	private String department;
	@Column
	@Nullable
	private String employeeType;
	
	public Employee() {
		this.salaryPerDay = SALARY_P_DAY_EMPLOYEE;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSalaryPerDay() {
		return salaryPerDay;
	}

	public void setSalaryPerDay(int salaryPerDay) {
		this.salaryPerDay = salaryPerDay;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public int findEmployeeById(List<Employee> list, int id) {
		if (list == null || list.size() == 0) {
			System.out.println("List employee is empty!");
			return -1;
		}
	
		for (int i = 0; i < list.size(); i++) {
			Employee e = list.get(i);
			if (e.id == id) {
				return i;
			}
		}
		
		return -1;
	}

	public void displayInfo() {
		System.out.println("Employee Id=" + id + ", name=" + name + ", phone=" + phone
				+ ", department= " + this.department + ", salaryPerDay=" + salaryPerDay);
	}
}

package com.qlns.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Employee {
	
	public static final int SALARY_P_DAY_EMPLOYEE = 100;
	public static final int SALARY_P_DAY_MANAGER = 200;
	public static final int SALARY_P_DAY_DIRECTOR = 300;

	public static final String TYPE_EMPLOYEE = "0";
	public static final String TYPE_DEPARTMENT_MANAGER = "1";
	public static final String TYPE_DIRECTOR = "2";
		
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String phone;
	@Column
	private double workDay;
	@Column
	private int salaryPerDay;
	@Column
	private String department;
	
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

	public double getWorkDay() {
		return workDay;
	}

	public void setWorkDay(double workDay) {
		this.workDay = workDay;
	}

	public long calculateSalary() {
		return (long) (this.salaryPerDay * workDay);
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
				+ ", department= " + this.department + ", salaryPerDay=" + salaryPerDay	+ ", workDay=" + workDay);
	}
}

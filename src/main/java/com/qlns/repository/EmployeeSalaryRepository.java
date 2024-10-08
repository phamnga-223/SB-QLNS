package com.qlns.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.qlns.model.EmployeeSalary;

public interface EmployeeSalaryRepository extends CrudRepository<EmployeeSalary, Integer> {

	@Query(value = "SELECT u FROM EmployeeSalary u WHERE u.employeeId = :employeeId")
	public EmployeeSalary findByEmployeeId(@Param("employeeId") int employeeId);

	@Query(value = "SELECT u FROM EmployeeSalary u WHERE u.employeeId = :employeeId AND u.month = :month")
	public EmployeeSalary findByEmployeeIdAndMonth(@Param("employeeId") int employeeId, @Param("month") int month);
}

package com.qlns.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.Month;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qlns.model.Employee;
import com.qlns.model.EmployeeSalary;
import com.qlns.repository.EmployeeSalaryRepository;

@Repository
public class EmployeeSalaryService {

	public static final int ALLOWANCE_PER_MONTH = 500000;
	public static final double INSURANCE_PERCENT = 10.5;
	public static final int INSURANCE_SALARY = 4960000; //https://thuvienphapluat.vn/phap-luat/ho-tro-phap-luat/cach-tinh-muc-luong-dong-bhxh-2024-tu-017-khi-tang-luong-toi-thieu-vung-cong-thuc-tinh-luong-dong-b-163276.html
	public static final String STATUS_PAID = "PAID";
	public static final String STATUS_UN_PAID = "UN_PAID";
	public static final String TEMPLATE_SALARY = "src\\main\\resources\\export\\employee\\template\\template-salary.xlsx";
	
	@Autowired
	private EmployeeSalaryRepository repository;
	
	@Autowired
	private EmployeeService employeeService;
	
	public EmployeeSalary getEmployeeSalary(int employeeId) {
		EmployeeSalary entity = repository.findByEmployeeId(employeeId);
		Employee employee = employeeService.findEmployee(employeeId);
		
		if (entity == null && employee != null) {
			entity = new EmployeeSalary();
			entity.setEmployeeId(employeeId);
		}
		
		return entity;
	}
	
	public EmployeeSalary calculateSalary(EmployeeSalary entity) {
		int employeeId = entity.getEmployeeId();
		Employee employee = employeeService.findEmployee(employeeId);
		
		if (employee == null) {
			return null;
		}
		
		int salary = calculateBaseSalary(employee.getSalaryPerDay(), entity.getWorkDay());
		int insurance = 0;
		if (salary >= INSURANCE_SALARY) {
			insurance = (int) (salary * INSURANCE_PERCENT / 100);
		}
		int allowance = entity.getWorkDay() * ALLOWANCE_PER_MONTH / 30;
		salary = salary + allowance - insurance;

		entity.setInsurance(insurance);
		entity.setAllowance(allowance);
		entity.setSalary(salary);
		
		return entity;
	}
	
	public EmployeeSalary saveSalary(EmployeeSalary entity) {		
		try {
			EmployeeSalary employeeSalary = repository.findByEmployeeIdAndMonth(entity.getEmployeeId(), entity.getMonth());
			if (employeeSalary != null) {
				entity = employeeSalary;
			}
			
			repository.save(entity);
			
			if (entity.getId() == 0) { 
				entity = repository.findByEmployeeIdAndMonth(entity.getEmployeeId(), entity.getMonth());
			}
		} catch (Exception ex) {
			System.out.println("Error!");
			ex.printStackTrace();			
		}
		
		return entity;
	}
	
	public String exportSalaryDividual(int id) {
		String result = "";
		
		try {
			if (!repository.existsById(id)) {
				return result;
			}
			EmployeeSalary entity = repository.findById(id).get();
			FileInputStream templateSalary = new FileInputStream(new File(TEMPLATE_SALARY));
			XSSFWorkbook  workbook = new XSSFWorkbook(templateSalary);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row; 
			XSSFCell cell;
			Employee employee = employeeService.findEmployee(entity.getEmployeeId());
			
			//Fill data
			//Time
			int rowNum = 5;
			row = sheet.getRow(rowNum);
			cell = row.getCell(2);
			String time = String.format("Tháng %s năm %s", entity.getMonth(), 2024);
			cell.setCellValue(time);
			
			//employeeId
			rowNum += 2;
			row = sheet.getRow(rowNum);
			cell = row.getCell(1);
			cell.setCellValue(entity.getEmployeeId());
			
			//name
			row = sheet.getRow(++rowNum);
			cell = row.getCell(1);
			cell.setCellValue(employee.getName());
			
			//department
			row = sheet.getRow(++rowNum);
			cell = row.getCell(1);
			cell.setCellValue(employee.getDepartment());
			
			//workDay
			row = sheet.getRow(++rowNum);
			cell = row.getCell(2);
			cell.setCellType(CellType.NUMERIC);
			cell.setCellValue(entity.getWorkDay());
			
			//base salary
			rowNum += 2;
			row = sheet.getRow(rowNum);
			cell = row.getCell(2);
			int baseSalary = calculateBaseSalary(employee.getSalaryPerDay(), entity.getWorkDay());
			cell.setCellValue(baseSalary);
			
			//allowance
			rowNum += 3;
			row = sheet.getRow(rowNum);
			cell = row.getCell(2);
			cell.setCellValue(entity.getAllowance());
			
			//sum salary
			row = sheet.getRow(++rowNum);
			cell = row.getCell(2);
			cell.setCellValue(baseSalary + entity.getAllowance());
			
			//insurance
			row = sheet.getRow(++rowNum);
			cell = row.getCell(2);
			cell.setCellValue(entity.getInsurance());
			
			//sum
			rowNum = 22;
			row = sheet.getRow(rowNum);
			cell = row.getCell(2);
			cell.setCellValue(entity.getSalary());
			
			//final salary
			row = sheet.getRow(++rowNum);
			cell = row.getCell(2);
			cell.setCellValue(entity.getSalary());
			
			//note
			row = sheet.getRow(++rowNum);
			cell = row.getCell(1);
			cell.setCellValue(entity.getNote());
			
			// Write output to the file
			String fileName = String.format("src/main/resources/export/employee/salary/Salary-%s-T%s-2024-v%s.xlsx"
					, employee.getName(), entity.getMonth(), System.currentTimeMillis());
			FileOutputStream fileOut = new FileOutputStream(fileName);
			workbook.write(fileOut);
			
			fileOut.close();
			workbook.close();
		} catch (Exception ex) {
			System.out.println("Error!");
			ex.printStackTrace();
		}
		
		return result;
	}
	
	public int calculateBaseSalary (int salaryPerDay, int workDay) {
		return salaryPerDay * workDay;
	}
}

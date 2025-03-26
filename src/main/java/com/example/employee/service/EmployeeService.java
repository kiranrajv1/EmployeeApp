package com.example.employee.service;

import java.util.List;


import com.example.employee.model.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	void deleteEmployee(Long id);
	
	Employee getEmployeeById(Long id);

	Employee updateEmployee(Long id, Employee employeeDetails);


	
}

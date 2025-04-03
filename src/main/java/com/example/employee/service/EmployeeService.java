package com.example.employee.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.employee.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployees();

	void deleteEmployee(Long id);

	Employee getEmployeeById(Long id);

	Employee updateEmployee(Long id, Employee employeeDetails);

	long getTotalEmployees();

	Page<Employee> searchEmployees(String department, String location, Pageable pageable);


}

package com.example.employee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
		
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	
	@Override
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = getEmployeeById(id);
        
        // Updating existing employee details
        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setSalary(employeeDetails.getSalary());
        return employeeRepository.save(employee);
    }
	
	

		@Override
		public void deleteEmployee(Long id) {
			// TODO Auto-generated method stub
			employeeRepository.deleteById(id);
		}

		@Override
		public Employee getEmployeeById(Long id) {
			// TODO Auto-generated method stub
			return employeeRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
		}
		
		
}

package com.example.employee.service;

import java.util.List;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;



@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee saveEmployee(Employee employee) {

		if (employee.getId() == null) {
			employee.setCreatedDate(LocalDateTime.now());
		}

        //employee.setCreatedDate(LocalDateTime.now());
        employee.setUpdatedDate(LocalDateTime.now());
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
		employee.setAddress(employeeDetails.getAddress());
		employee.setLocation(employeeDetails.getLocation());
		employee.setUpdatedDate(LocalDateTime.now());
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

	@Override
	public long getTotalEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.getTotalEmployees();
	}

	public Page<Employee> searchEmployees(String department, String location, Pageable pageable) {
        if (department != null && !department.isEmpty() && location != null && !location.isEmpty()) {
            return employeeRepository.findByDepartmentAndLocation(department, location, pageable);
        } else if (department != null && !department.isEmpty()) {
           return employeeRepository.findByDepartment(department, pageable);
        } else if (location != null && !location.isEmpty()) {
            return employeeRepository.findByLocation(location, pageable);
        } else {
            return employeeRepository.findAll(pageable);
        }
    }


}



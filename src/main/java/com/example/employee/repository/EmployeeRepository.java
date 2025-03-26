package com.example.employee.repository;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	

	
}

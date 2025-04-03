package com.example.employee.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, PagingAndSortingRepository<Employee, Long> {

	@Query("Select count(e) from Employee e ")
	long getTotalEmployees();


	// with paging
	Page<Employee> findByDepartmentAndLocation(String department, String location, Pageable pageable);

	Page<Employee> findByDepartment(String department, Pageable pageable);

	Page<Employee> findByLocation(String location, Pageable pageable);

}

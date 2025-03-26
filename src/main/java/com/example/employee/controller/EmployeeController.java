//package com.example.employee.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.employee.model.Employee;
//import com.example.employee.service.EmployeeService;
//
//@RestController
//@RequestMapping("/employees")
//public class EmployeeController {
//	
//	@Autowired
//	private EmployeeService employeeService;
//	
//	@GetMapping("/{id}")
//    public String checkEmployee(@PathVariable Long id) {
//        return employeeService.getEmployeeById(id);
//    }
//	
//	
//	@PostMapping("/addEmployee")
//	public Employee createEmployee(@RequestBody Employee employee) {
//		return employeeService.saveEmployee(employee);
//	}
//
//	@GetMapping("/all")
//	public List<Employee> getAllEmployee(){
//		return employeeService.getAllEmployees();
//		
//	}
//	
//	@PutMapping("updateEmployee/{id}")
//	public ResponseEntity<ResponseEntity<Employee>> updateEmployee(@PathVariable Long id,@RequestBody Employee updatedEmployee){
//		
//		ResponseEntity<Employee> employee = employeeService.updateEmployee(id, updatedEmployee);
//        return ResponseEntity.ok(employee);
//	}
//
//	@DeleteMapping("deleteById/{id}")
//	public String deleteEmployee(@PathVariable Long id,@RequestBody Employee employee) {
////		employeeService.deleteEmployee(id);
////		return "Employee deleted successfully";
//		return employeeService.deleteEmployee(id);
//	}
//
//}
//

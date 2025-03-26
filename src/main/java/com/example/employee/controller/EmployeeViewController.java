package com.example.employee.controller;


import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import java.util.List;
 
@Controller
@RequestMapping("/employees")
public class EmployeeViewController {
 
    @Autowired
    private EmployeeService employeeService;
 
    // Show employee list page
    @GetMapping
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee-list";
    }
 
    // Show add employee form
    @GetMapping("/new")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }
 
    // Save employee
//    @PostMapping("/save")
//    public String saveEmployee(@ModelAttribute Employee employee) {
//        employeeService.saveEmployee(employee);
//        return "redirect:/employees";
//    }
 
    
    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "employee-form";
        }
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee-form"; // Reusing the same form for edit
    }
     
//    @PostMapping("/update/{id}")
//    public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee employee) {
//        employeeService.updateEmployee(id, employee);
//        return "redirect:/employees";
//    }
    
    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, @Valid @ModelAttribute Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "employee-form";
        }
        employeeService.updateEmployee(id, employee);
        return "redirect:/employees";
    }
    
 // Delete employee
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
   
        
    }

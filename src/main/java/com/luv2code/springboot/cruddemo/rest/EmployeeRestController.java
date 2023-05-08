package com.luv2code.springboot.cruddemo.rest;

import java.util.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAllEmployees(){
		System.out.println("Find all employees called.");
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeID}")
	public Employee findEmployeeById(@PathVariable int employeeID) {
		Employee employee = employeeService.findById(employeeID);
		if(employee == null) {
			throw new RuntimeException("Employee id not found: "+employeeID);
		}
		return employee;
	}
	
	// Add a post construct
	@PostMapping("/employees")
	public Employee addNewEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		
		Employee dbEmployee = employeeService.save(theEmployee);
		
		return dbEmployee;
	}
}

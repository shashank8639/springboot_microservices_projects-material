package com.data.jpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.jpa.model.Employee;
import com.data.jpa.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping
	public Employee saveEmp(@RequestBody Employee employee) {

		return employeeService.saveEmp(employee);
	}
	
	@GetMapping
	public List<Employee> getEmps() {

		return employeeService.getEmps();
	}
	
	@GetMapping("/id/{id}")
	public Employee getEmp(@PathVariable Long id) {

		return employeeService.getEmp(id);
	}
}

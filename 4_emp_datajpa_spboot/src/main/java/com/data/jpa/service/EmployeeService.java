package com.data.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.data.jpa.model.Employee;
import com.data.jpa.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	public Employee saveEmp(Employee employee) {

		return employeeRepository.save(employee);
	}

	public List<Employee> getEmps() {

		return employeeRepository.findAll();
	}

	public Employee getEmp(Long id) {

		Optional<Employee> optional = employeeRepository.findById(id);
		
		if(optional.isPresent())
			return optional.get();
		
		return null;
	}
	
	
	
}

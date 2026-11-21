package com.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.jpa.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
}

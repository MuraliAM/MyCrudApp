package com.example.demo.service;

import java.util.Optional;

import com.example.demo.domain.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public Iterable<Employee> getEmployees();
	
	public String deleteEmployee(int id);

	public Optional<Employee> getEmployee(int id);
	
	
}

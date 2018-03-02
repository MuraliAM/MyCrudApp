package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeSeviceImpl implements EmployeeService {

	private final EmployeeRepository empRepository;

	public EmployeeSeviceImpl(EmployeeRepository empRepository) {
		this.empRepository = empRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		return empRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployees() {
		return empRepository.findAll();

	}

	public String deleteEmployee(int id) {
		empRepository.deleteById(id);
		return "success";

	}

	@Override
	public Optional<Employee> getEmployee(int id) {

		return empRepository.findById(id);
	}

}

package com.example.demo.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeService;

import javassist.NotFoundException;

@RestController
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping("/save")
	public ResponseEntity<Integer> saveEmp() {

		Employee emp = new Employee("Murali", 23, 8, "RCL", LocalDate.of(2009, 10, 12));

		Employee createdEmpl = employeeService.saveEmployee(emp);

		return new ResponseEntity<Integer>(createdEmpl.getId(), HttpStatus.CREATED);

	}

	@GetMapping("/employee")
	public Iterable<Employee> getAllEmployees() {

		return employeeService.getEmployees();

	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> findEmployee(@PathVariable int id) throws NotFoundException {

		Optional<Employee> employee = employeeService.getEmployee(id);

		if (employee.isPresent()) {
			return new ResponseEntity<Employee>(employee.get(), HttpStatus.OK);
		} else {
			throw new NotFoundException("Employee Not found");
		}

	}
	
	@ExceptionHandler(value=NotFoundException.class)
	public ResponseEntity<String> catchEx(Exception e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		
	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable int id) {

		String result = employeeService.deleteEmployee(id);
		return new ResponseEntity<String>(result, HttpStatus.OK);

	}

}

package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	List<Employee> findAll();
	
	Optional<Employee> findById(int id);
	
	void deleteById(int id);
	
}

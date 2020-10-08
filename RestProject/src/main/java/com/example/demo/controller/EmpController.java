package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmpController {

	@Autowired
	EmployeeService service;
	
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody @Valid Employee emp) {
		return service.saveEmployee(emp);
	}
	
	@GetMapping("/all")
	public List<Employee> findAll(){
		return service.getAll();
	}
	
	@GetMapping("/find/{id}")
	@ResponseStatus(value=HttpStatus.FOUND)
	public Optional<Employee> findById(@PathVariable int id) {		
		Optional<Employee> byID = service.getByID(id);		
		return byID;
	}
	
	@GetMapping("/empM")
	public Optional<List<Employee>> getNameWithM() {
		Optional<List<Employee>> nameWithM = service.getNameWithM();
		if(!nameWithM.isPresent())
			throw new EmployeeNotFoundException("Not found ");
		return nameWithM;
	}
	
	@GetMapping("/empSalary")
	public List<Employee> getSalaryGreaterThan10(){
		return service.getSalaryGreaterThan10();
	}
	
	@GetMapping("/dept/{dept}")
	public Optional<Employee> getByDept(@PathVariable String dept){
		Optional<Employee> findByDept = service.findByDept(dept);
		if(!findByDept.isPresent()) 
			throw new EmployeeNotFoundException("Not Found " + dept);
		return findByDept;
	}
}

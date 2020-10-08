package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmpRepository;

@Service
public class EmployeeService {
	
	
	@Autowired
	EmpRepository repo;
	private List<Employee> findAll;
	
	public Employee saveEmployee(Employee emp) {
		return repo.save(emp);
	}
	
	public List<Employee> getAll(){
		return repo.findAll();		
	}
	
	public Optional<Employee> getByID(int id) {
		Optional<Employee> findById = repo.findById(id);
		if(!findById.isPresent())
			throw new EmployeeNotFoundException("Not found " + id);
		return findById;
	}
	
	public Optional<List<Employee>> getNameWithM() {
		
		findAll = repo.findAll();
		List<Employee> collect = findAll.stream().filter(t -> t.getName().startsWith("M")).collect(Collectors.toList());
		return Optional.of((collect));		
	}
	
	public List<Employee> getSalaryGreaterThan10(){
		findAll=repo.findAll();
		List<Employee> collect=findAll.stream().filter(t -> t.getSalary() > 1000000).collect(Collectors.toList());
		return collect;
	}
		
	public Optional<Employee> findByDept(String dept){
		return repo.findByDept(dept);
	}
	
}
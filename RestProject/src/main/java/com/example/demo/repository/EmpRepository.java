package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {
	
	public Optional<Employee> findByDept(String dept);

}

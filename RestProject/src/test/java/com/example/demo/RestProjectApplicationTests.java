package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmpRepository;
import com.example.demo.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestProjectApplicationTests {
	
	@Autowired
	private EmployeeService service;
	
	@MockBean
	private EmpRepository repo;
	
	@Test
	public void getEmpTest() {
		when(repo.findAll()).thenReturn(Stream.
				of(new Employee (10,"Sam","IT",50000)).collect(Collectors.toList()));
		assertEquals(1, service.getAll().size());
	}
	
	@Test
	public void getEmpBySalary() {
	when(service.getSalaryGreaterThan10()).thenReturn(Stream.of(
			new Employee(23,"Bill","IT",320000), new Employee(24,"Bill","IT",3200000),new Employee(25,"Wayne","IT",3200000)).collect(Collectors.toList()));
	
	assertEquals(2, service.getSalaryGreaterThan10().size());
	}
	
//	@Test
//	public void getByDept() {
//		String dept="Social";
//		when(repo.findByDept(dept)).thenReturn(Stream.of(
//				new Employee(10,"Sam","Social",533232)).collect(Collectors.toList()));
//		assertEquals(1, service.findByDept(dept).size());
//	}
	
	@Test
	public void saveEmp() {
		Employee emp=new Employee(23,"John","Social",323232);
		when(repo.save(emp)).thenReturn(emp);
		assertEquals(emp, service.saveEmployee(emp));
	}
	
}

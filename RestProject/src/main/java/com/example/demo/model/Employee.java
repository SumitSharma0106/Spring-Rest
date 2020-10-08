package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
	
	@Id
	private int id;	
	@Size(min = 2,max=30,message = "Please enter valid details, min = 2 and max = 30")
	@NotNull
	private String name;
	@Size(min = 2,max=30,message = "Please enter valid details, min = 2 and max = 30")
	@NotNull	
	private String dept;
	@NotNull
	private int salary;

	}



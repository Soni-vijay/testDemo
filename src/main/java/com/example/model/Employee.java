package com.example.model;

import java.sql.SQLException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull(message = "Please enter id")
	private Long id;
	
	@NotEmpty(message = "Please provide a name")
	@Size(max = 20, min = 3, message = "{user.name.invalid}")
	@Column(name = "empName")
	private String name;
	
	//@NotEmpty(message = "Please provide  salary")
	//@DecimalMin("1.00")
	//@Column(name = "empSalary")
	private double sal;

	@NotEmpty(message = "Please provide designation")
	@Column(name = "empDesignation")
	private String designation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Object thenReturn(SQLException sqlException) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

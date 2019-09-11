package com.example.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("employeecontroller")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) throws SQLException {

		try {
		Employee addEmployee = employeeService.addEmployee(employee);

		if (null != addEmployee) {
			

			return new ResponseEntity<Object>(employee, HttpStatus.OK);

		} else {
			return new ResponseEntity<Object>(employee, HttpStatus.BAD_REQUEST);
		}
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>(employee,HttpStatus.EXPECTATION_FAILED);
		}
		
		
	}

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public List<Employee> getAllEmployee() {
		List<Employee> customerRegList = employeeService.getAllEmployee();
		if (customerRegList != null) {
			return customerRegList;
		} else {
			return null;
		}
	}
	
	
	public void m1() {
		
	}
	
	
	
	
	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public ResponseEntity<Employee> getAllEmployee1() {
		List<Employee> customerRegList = employeeService.getAllEmployee();
		if (customerRegList != null) {
			return new ResponseEntity<Employee>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);

		}
	}
	
	
	
	
	
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		
		Employee updateEmployee = employeeService.updateEmployee(employee);
		if(null!=updateEmployee) {
			return new ResponseEntity<Employee>(HttpStatus.OK);
		}
		else {
		
		return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
}

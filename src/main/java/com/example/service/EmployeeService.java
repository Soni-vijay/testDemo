package com.example.service;

import java.sql.SQLException;
import java.util.List;

import com.example.model.Employee;


public interface EmployeeService {


	Employee addEmployee(Employee employee) throws SQLException;
	
	List<Employee> getAllEmployee();

	Employee getEmployeeById(Long id);

    void deleteEmployeeById(Long id);

    Employee updateEmployee(Employee emp);
	
}

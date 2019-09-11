package com.example.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repo.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService
{
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee addEmployee(Employee employee) throws SQLException {
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepo.getOne(id);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepo.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		
		
		return employeeRepo.save(emp);
	}

}

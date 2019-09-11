package com.example.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.model.Employee;
import com.example.service.EmployeeService;

public class EmployeeControllerTest {

	@Mock
	private EmployeeService employeeService;

	@InjectMocks
	private EmployeeController employeeController;

	/*
	 * @Spy ResponseEntity<Object> successResponse = new
	 * ResponseEntity<>(HttpStatus.OK);
	 */
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateEmployee_whenHttpStatusIsOK() throws Exception {
		Employee employee = new Employee();
		when(employeeService.addEmployee(employee)).thenReturn(employee);
		ResponseEntity<Object> createEmployee = employeeController.createEmployee(employee);
		assertEquals(HttpStatus.OK, createEmployee.getStatusCode());
	}

	@Test
	public void testCreateEmployee_whenHttpStatusIsBAD_REQUEST() throws Exception {
		Employee employee = new Employee();
		when(employeeService.addEmployee(employee)).thenReturn(null);
		ResponseEntity<Object> createEmployee = employeeController.createEmployee(employee);
		assertEquals(HttpStatus.BAD_REQUEST, createEmployee.getStatusCode());

	}

	@Test
	public void testCreateEmployeeException() throws SQLException {
		Employee employee = new Employee();
		ResponseEntity<Object> responseEntity = employeeController.createEmployee(employee);
		when(employeeService.addEmployee(employee)).thenThrow(new SQLException());		
		assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
		HttpStatus statusCode = responseEntity.getStatusCode();
		assertEquals(HttpStatus.CONFLICT, statusCode);
	}

	@Test
	public void testGetAllEmployeePositive() {
		List<Employee> allEmployee = employeeController.getAllEmployee();
		when(employeeService.getAllEmployee()).thenReturn(allEmployee);
		assertEquals(allEmployee, allEmployee);

	}

	@Test
	public void testGetAllEmployeeNegative() {
		List<Employee> allEmployee = employeeController.getAllEmployee();
		when(employeeService.getAllEmployee()).thenReturn(null);
		assertEquals(allEmployee, allEmployee);

	}

	@Test
	public void testGetAllEmployeeNegatvic() {
		ResponseEntity<Employee> allEmployee1 = employeeController.getAllEmployee1();
		when(employeeService.getAllEmployee()).thenReturn(null);
		assertEquals(allEmployee1, allEmployee1);
	}

}

package com.example.TestController;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.controller.EmployeeController;
import com.example.model.Employee;
import com.example.service.EmployeeService;
import com.example.service.EmployeeServiceImpl;

public class testEmployeeController {

	@InjectMocks
	EmployeeController employeeController;

	@Mock
	EmployeeService employeeService;

	@Spy
	Employee employee;

	@Before
	public void init() throws Exception {
		employeeController = new EmployeeController();
		employeeService = mock(EmployeeServiceImpl.class);
		setCollaborator(employeeController, "employeeService", employeeService);
	}

	// reflection api
	public void setCollaborator(Object object, String name, Object service) throws Exception {
		Field field;
		field = object.getClass().getDeclaredField(name);
		field.setAccessible(true);
		field.set(object, service);
	}
	/*
	 * public List<Employee> getEmployeeList() { List<Employee> busDetailsList = new
	 * ArrayList<Employee>(); Employee emp = new Employee(); emp.setId((long) 101);
	 * emp.setName("ajay"); emp.setDesignation("java"); emp.setSal(733.3); return
	 * (List<Employee>) emp; }
	 */

	// ---------Request Object null test---------------
	@Test
	public void EmployeeNullTest() throws SQLException {
		Employee emp = null;
		when(employeeService.addEmployee(employee)).thenReturn(emp);
		ResponseEntity<Object> setBus = employeeController.createEmployee(emp);
		HttpStatus unitCode = setBus.getStatusCode();
		assertEquals(HttpStatus.BAD_REQUEST, unitCode);
	}

	@Test
	public void EmployeenotNullTest() throws SQLException {
		// Employee employeeList = getEmployeeList();

		Employee emp = new Employee();
		emp.setId((long) 101);
		emp.setName("ajay");
		emp.setDesignation("java");
		emp.setSal(733.3);

		when(employeeService.addEmployee(emp)).thenReturn(emp);
		ResponseEntity<Object> setBus = employeeController.createEmployee(emp);
		HttpStatus unitCode = setBus.getStatusCode();
		assertEquals(HttpStatus.OK, unitCode);
	}

	@Test
	public void setExceptionTest12() throws Exception {

		// BusinessUnitRequest businessUnitsRequest = new BusinessUnitRequest();
		Employee emp = new Employee();

		emp.setName(emp.getName());

		emp.setSal(emp.getSal());
		emp.setDesignation(emp.getDesignation());
		emp.setId(emp.getId());

		when(employeeService.addEmployee(emp)).thenThrow(new RuntimeException());
		ResponseEntity<Object> createEmployee = employeeController.createEmployee(employee);
		HttpStatus unitCode = createEmployee.getStatusCode();

		assertEquals(HttpStatus.BAD_REQUEST, unitCode);
	}

	@Test
	public void setSQLExceptionTest() throws SQLException {

		Employee emp = new Employee();
		emp.setName(emp.getName());
		emp.setSal(emp.getSal());
		emp.setDesignation(emp.getDesignation());
		emp.setId(emp.getId());
		when(employeeService.addEmployee(employee)).thenThrow(SQLException.class);
		ResponseEntity<Object> setBus = employeeController.createEmployee(employee);
		HttpStatus unitCode = setBus.getStatusCode();
		assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, unitCode);

	}

	@Test
	public void setExceptionTest1() throws Exception {
		Employee emp = new Employee();
		emp.setName(emp.getName());
		emp.setSal(emp.getSal());
		emp.setDesignation(emp.getDesignation());
		emp.setId(emp.getId());
		when(employeeService.addEmployee(employee)).thenThrow(new RuntimeException());
		ResponseEntity<Object> createEmployee = employeeController.createEmployee(emp);
		HttpStatus unitCode = createEmployee.getStatusCode();
		System.out.println(unitCode);
		assertEquals(HttpStatus.CONFLICT, unitCode);

	}

	// ----------GetAll test case--------------
	@Test
	public void testGetbusinessUnit() throws SQLException {
		Employee emp = new Employee();
		emp.setName(emp.getName());
		emp.setSal(emp.getSal());
		emp.setDesignation(emp.getDesignation());
		emp.setId(emp.getId());
		when(employeeService.addEmployee(employee));// .thenReturn(successResponse);

		ResponseEntity<Object> createEmployee = employeeController.createEmployee(emp);
		HttpStatus status = createEmployee.getStatusCode();
		assertEquals(HttpStatus.OK, status);
	}
	

	// ---------------Request null test--------------------
	@Test
	public void getRequestNullTest() throws SQLException {
		Employee emp = null;
		when(employeeService.addEmployee(employee)).thenReturn(null);
		ResponseEntity<Object> createEmployee = employeeController.createEmployee(emp);
		HttpStatus status = createEmployee.getStatusCode();
		assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, status);

	}

}

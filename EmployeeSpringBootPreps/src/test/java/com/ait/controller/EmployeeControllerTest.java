
package com.ait.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.ait.model.Employee;
import com.ait.service.IEmployeeService;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

	@Mock
	private IEmployeeService service;

	@InjectMocks
	private EmployeeController controller;

	private Employee employee;

	@BeforeEach
	void setUp() {
		employee = new Employee();
		employee.setId(1);
		employee.setName("John Doe");
		employee.setAddress("123 Main St");
		employee.setSalary(50000);
		employee.setMobile(9876543210L);
		System.out.println("BeforeEach");
	}
	
	@BeforeAll
	static void init() {
		System.out.println("Before All");
	}
	
	@AfterAll
	static void destory() {
		System.out.println("After All");
	}
	

	@AfterEach
	void tearDown() {
		System.out.println("Clean up");
	}
	
	@Test
	void testSaveEmployee() {
		System.out.println("=====testSaveEmployee=====");
		when(service.save(any(Employee.class))).thenReturn(employee);

		ResponseEntity<Employee> response = controller.saveEmployee(employee);

		assertNotNull(response);
		assertEquals(200, response.getStatusCodeValue());
		assertEquals(employee, response.getBody());
	}

	@Test
	@Disabled
	void testGetAllEmployees() {
		System.out.println("=====testGetAllEmployees=====");
		List<Employee> employees = Arrays.asList(employee);
		when(service.getAllEmployees()).thenReturn(employees);

		ResponseEntity<List<Employee>> response = controller.getAllEmployees();

		assertNotNull(response);
		assertEquals(200, response.getStatusCodeValue());
		assertEquals(employees, response.getBody());
	}
}

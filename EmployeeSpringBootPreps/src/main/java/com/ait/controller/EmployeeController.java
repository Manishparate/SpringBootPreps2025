package com.ait.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ait.model.Employee;
import com.ait.service.IEmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private IEmployeeService service;

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		Employee saveEmp = service.save(emp);
		return new ResponseEntity<>(saveEmp, HttpStatus.OK);
	}

	@PostMapping("saveAll")
	public ResponseEntity<List<Employee>> saveAll(@RequestBody List<Employee> list) {
		List<Employee> saveAll = service.saveAll(list);
		return new ResponseEntity<List<Employee>>(saveAll, HttpStatus.OK);
	}

	@PostMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
		Employee upEmp = service.update(emp);
		return new ResponseEntity<Employee>(upEmp, HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> allEmployees = service.getAllEmployees();
		return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<Employee>> getById(@PathVariable("id") Integer id) {
		Optional<Employee> emp = service.getById(id);
		return new ResponseEntity<Optional<Employee>>(emp, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") Integer id) {
		service.deleteById(id);
		return "Employee with id" + id + " is removed from the system";
	}

	@DeleteMapping("delete")
	public String deleteAll() {
		service.deleteAll();
		return "All Employees are removed from the system";
	}

}

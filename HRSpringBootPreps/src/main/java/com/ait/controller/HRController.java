package com.ait.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ait.model.Employee;
import com.ait.relation_mapping.Address;
import com.ait.relation_mapping.HR;
import com.ait.service.IHRService;

@RestController
@RequestMapping("/hr")
public class HRController {

	@Autowired
	private IHRService service;

	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getEmployeeSalary(@PathVariable("id") Integer id) {
		ResponseEntity<String> response = service.getEmployeeSalary(id);
		return new ResponseEntity<Object>(response.getBody(), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Employee> postEmployee(@RequestBody Employee emp) {
		ResponseEntity<Employee> postEmployee = service.postEmployee(emp);
		return new ResponseEntity<Employee>(postEmployee.getBody(), HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<HR>> getAllHR() {
		return new ResponseEntity<List<HR>>(service.getAllHR(), HttpStatus.OK);
	}

	@PostMapping("/saveHR")
	public ResponseEntity<HR> saveHR(@RequestBody HR hr) {
		return new ResponseEntity<HR>(service.saveHR(hr), HttpStatus.OK);
	}

	@GetMapping("/getHR/{id}")
	public ResponseEntity<HR> getById(@PathVariable("id") Integer id) {
		HR hr = service.findById(id);
		return new ResponseEntity<HR>(hr, HttpStatus.OK);
	}

	@PostMapping("/saveAdd")
	public ResponseEntity<Address> saveAddress(@RequestBody Address address) {
		return new ResponseEntity<Address>(service.saveAddress(address), HttpStatus.OK);
	}

}
package com.ait.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ait.model.Employee;
import com.ait.relation_mapping.Address;
import com.ait.relation_mapping.HR;

public interface IHRService {

	public ResponseEntity<String> getEmployeeSalary(Integer id);

	public ResponseEntity<Employee> postEmployee(Employee emp);

	public List<HR> getAllHR();

	public HR saveHR(HR hr);

	public Address saveAddress(Address add);

	public HR findById(Integer id);

}

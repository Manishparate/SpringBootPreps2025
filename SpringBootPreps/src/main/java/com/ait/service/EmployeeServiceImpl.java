package com.ait.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.exception.ResourceNotFoundException;
import com.ait.model.Employee;
import com.ait.repo.IEmployeeRepository;

@Service("empService")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository repo;

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public Employee save(Employee emp) {
		return repo.save(emp);
	}

	@Override
	public Employee update(Employee emp) {

		return repo.findById(emp.getId()).map(upEmp -> {
			upEmp.setName(emp.getName());
			upEmp.setAddress(emp.getAddress());
			upEmp.setMobile(emp.getMobile());
			return repo.save(upEmp);
		}).orElseThrow(() -> new ResourceNotFoundException("Employee is not found with id " + emp.getId()));
	}

	@Override
	public List<Employee> saveAll(List<Employee> list) {
		return repo.saveAll(list);
	}

	@Override
	public void deleteById(Integer id) {
		repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee is not found with id "+id));
		repo.deleteById(id);
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
	}

}

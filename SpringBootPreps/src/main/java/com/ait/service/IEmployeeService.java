package com.ait.service;

import java.util.List;

import com.ait.model.Employee;

public interface IEmployeeService {

	public List<Employee> getAllEmployees();

	public Employee save(Employee emp);

	public List<Employee> saveAll(List<Employee> list);

	public Employee update(Employee emp);

	public void deleteById(Integer id);

	public void deleteAll();

}

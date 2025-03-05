package com.ait.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.ait.exception.ResourceNotFoundException;
import com.ait.model.Employee;
import com.ait.relation_mapping.Address;
import com.ait.relation_mapping.HR;
import com.ait.repository.AddressRepository;
import com.ait.repository.HRRepository;

//@Service("hrService")
public class HRServiceImpl implements IHRService {

	@Autowired
	private RestTemplate template;

	@Autowired
	private HRRepository repo;

	@Autowired
	private AddressRepository addRepo;

	@Override
	public ResponseEntity<String> getEmployeeSalary(Integer id) {
		try {
			String url = "http://localhost:9295/emp/get/" + id;
			ResponseEntity<String> forEntity = template.getForEntity(url, String.class);
			System.out.println(forEntity);
			return forEntity;
		} catch (HttpClientErrorException e) {
			throw new ResourceNotFoundException(e.getLocalizedMessage());

		}
	}

	public ResponseEntity<Employee> postEmployee(Employee emp) {
		String url = "http://localhost:9295/emp/save";
		ResponseEntity<Employee> postForEntity = template.postForEntity(url, emp, Employee.class);
		return postForEntity;
	}

	@Override
	public List<HR> getAllHR() {
		return repo.findAll();
	}

	@Override
	public HR saveHR(HR hr) {
		return repo.save(hr);
	}

	@Override
	public Address saveAddress(Address add) {
		return addRepo.save(add);
	}

	@Override
	public HR findById(Integer id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Data not found for HR Id " + id));
	}

}

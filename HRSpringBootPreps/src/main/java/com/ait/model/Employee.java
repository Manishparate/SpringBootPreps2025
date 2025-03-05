package com.ait.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Employee {

	@Id
	private Integer id;
	private String name;
	private String address;
	private Integer salary;
	private Long mobile;

}

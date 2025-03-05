
package com.ait.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data

@Entity

@Table(name = "employee")
public class Employee {

	@Id

	@GeneratedValue

	@Column(name = "id", length = 5)
	private Integer id;

	@Column(name = "name", length = 10)
	private String name;

	@Column(name = "address", length = 20)
	private String address;

	@Column(name = "mobile", length = 10)
	private Long mobile;

	
}

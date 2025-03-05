package com.ait.relation_mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50, nullable = false)
	private String city;

	@Column(length = 100, nullable = false)
	private String street;

//	@OneToOne(mappedBy = "address")
//	@ManyToOne
//	@JsonIgnore // Prevent circular reference during JSON serialization
//	private HR hr;
}

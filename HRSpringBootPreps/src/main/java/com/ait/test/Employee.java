package com.ait.test;



public class Employee {
	private int id;
	private String name; 
	private String address;
	private Long mobile;
	
	public Employee() {
	}
	
	public Employee(int id, String name, String address, Long mobile) {
		this.id  = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	// create table Employee(INT id primary key, Varchar(10) name unique key, INT department id foreign key);
	
	
	
	
	// sort department by it's name;
	
	// select * from department 
	// order by department.name;
	
	// select query to display dname and count of department name;
	// select * from department  order by d.name count();
	
	

}

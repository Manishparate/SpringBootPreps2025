package com.ait.test;

public class Test {
	private int salary;

	// final, finally, finalize();
	// REactive programming
	// Spring profiles
	// Spring Actuators
	// dsa
	// spring security
	// applications.properties
	// what is yaml
	//

	// sql
	// primary, unique and foreign key
	// second highest salary
	// joins
	// clauses
	// aggregate functions
	// intersections

	
	public int getSalary() {
		return this.salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.err.println(this.salary);
		System.err.println("finalize called");
		super.finalize();
		
	}
}

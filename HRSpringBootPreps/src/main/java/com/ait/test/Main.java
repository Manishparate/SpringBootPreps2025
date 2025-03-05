package com.ait.test;

public class Main {

	public static void main(String[] args) {
		Test t = new Test();
		t.setSalary(50000);
		System.out.println(t.getSalary());
		t = null;
		System.gc();

	}
}

package com.ait.test;

import java.util.HashMap;

public class Test2 {
	public static void main(String[] args) {
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "Manish");
//		map.putIfAbsent("isPromoteApi", true);
		
		System.out.println(map.get("isPromoteApi"));
		
		
	}
	

}
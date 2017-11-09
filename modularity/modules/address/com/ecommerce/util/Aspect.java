package com.ecommerce.util;

public class Aspect {
	private static void before(String operation){
		System.out.println("Before operation: " + operation);
	}
	
	private static void after(String operation){
		System.out.println("After operation: " + operation);
	}
}
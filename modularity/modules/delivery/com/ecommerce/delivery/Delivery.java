package com.ecommerce.delivery;
import com.ecommerce.address.Address;

public class Delivery {
	public String greet(){
		return "Delivery speaking ...!";
	}
	
	public String address(){
		return new Address().greet();
	}
} 
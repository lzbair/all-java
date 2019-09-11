package com.ecommerce.delivery;
import com.ecommerce.address.Address;
import java.util.List;

public class Delivery {
	public String greet(){
		return "Delivery speaking ...!";
	}
	
	public String address(){
		return new Address().greet();
	}
	
	public String mode(){
		return new DeliveryMode().greet();
	}
	
	public List<DeliveryZone> zones(){
		return new DeliveryMode().supportedZones();
	}
} 
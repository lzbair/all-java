package com.ecommerce.delivery;

import java.util.Arrays;
import java.util.List;

public class DeliveryMode {
	public String greet(){
		return "Delivery Mode here ...!";
	}
	
	public List<DeliveryZone> supportedZones(){
		return Arrays.asList(new DeliveryZone("D"), new DeliveryZone("A"), new DeliveryZone("Y"));
	}
} 
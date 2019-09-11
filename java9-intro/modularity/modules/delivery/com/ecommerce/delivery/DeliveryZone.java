package com.ecommerce.delivery;

public class DeliveryZone implements Comparable<DeliveryZone>{
	
	private final String code;
	
	public DeliveryZone(String code) {
		this.code = code;
	}
	
	public String greet(){
		return "Delivery zone code: " + this.code;
	}
	
	public int compareTo(DeliveryZone z) {
        return this.code.compareTo(z.code);
    }
	
	public String toString() {
        return "Zone: " + this.code;
    }
} 
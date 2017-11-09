package com.ecommerce;
import com.ecommerce.delivery.Delivery;
import java.lang.reflect.Method;

public class Shop {
	public static void main(String... args) throws Exception{
		join("com.ecommerce.util.Aspect", "before");

		final Delivery delivery = new Delivery();
		System.out.println("Delivery says: " + delivery.greet());
		System.out.println("Adderess says: " + delivery.address());
		
		join("com.ecommerce.util.Aspect", "after");
	}
	
	private static void join(String proxy, String stage) throws Exception{
		Class aspect = Class.forName(proxy);
		Method m = aspect.getDeclaredMethod(stage, String.class);
		m.setAccessible(true);
		m.invoke(null, "Shopping ...");
	}
} 
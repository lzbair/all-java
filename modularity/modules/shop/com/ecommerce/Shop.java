package com.ecommerce;
import com.ecommerce.delivery.Delivery;
import com.ecommerce.delivery.DeliveryZone;
import java.lang.reflect.Method;
import java.util.List;
import com.service.toolkit.Sort;


public class Shop {
	public static void main(String... args) throws Exception{
		join("com.toolkit.monitor.Aspect", "before");

		final Delivery delivery = new Delivery();
		System.out.println("Delivery says: " + delivery.greet());
		System.out.println("Adderess says: " + delivery.address());
		List<DeliveryZone> zones = Sort.lookup().<DeliveryZone>sort(delivery.zones());
		System.out.println("Sorted delivery zones: " + zones);
		
		join("com.toolkit.monitor.Aspect", "after");
	}
	
	private static void join(String proxy, String stage) throws Exception{
		Class aspect = Class.forName(proxy);
		Method m = aspect.getDeclaredMethod(stage, String.class);
		m.setAccessible(true);
		m.invoke(null, "Shopping ...");
	}
} 
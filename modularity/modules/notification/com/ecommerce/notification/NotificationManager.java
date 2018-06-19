package com.ecommerce.notification;

public class NotificationManager {
	public void doNotify(Notification notification){
		NotificationSubscriber1 subscriber1 = new NotificationSubscriber1();
		NotificationPublisher publisher = new NotificationPublisher();
		publisher.subscribe(subscriber1);

	}
} 
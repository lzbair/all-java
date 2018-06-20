package com.ecommerce.notification.controller;

import com.ecommerce.notification.subscription.NotificationPublisher;
import com.ecommerce.notification.subscription.NotificationSubscriber;

public class NotificationController {

    private final NotificationPublisher publisher;

    public NotificationController() {
        this.publisher = new NotificationPublisher();
    }

    public Runnable doNotify(Notification notification) {
        publisher.submit(notification);
        return new Runnable() {
            @Override
            public void run() {
                publisher.subscribe(new NotificationSubscriber());
            }
        };
    }
} 
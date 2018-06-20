package com.ecommerce.notification.controller;

import com.ecommerce.notification.subscription.NotificationPublisher;

public class NotificationController {

    private final NotificationPublisher publisher = NotificationPublisher.create();

    public void doNotify(Notification notification) {
        publisher.submit(notification);
    }
} 
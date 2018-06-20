package com.ecommerce.notification.subscription;

import com.ecommerce.notification.controller.Notification;

import java.util.concurrent.SubmissionPublisher;

public class NotificationPublisher extends SubmissionPublisher<Notification> {


    public static NotificationPublisher create() {
        NotificationPublisher publisher = new NotificationPublisher();
        publisher.consume(new NotificationSubscriber());
        return publisher;
    }
}

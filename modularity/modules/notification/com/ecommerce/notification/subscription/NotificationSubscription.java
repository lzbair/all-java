package com.ecommerce.notification.subscription;

import com.ecommerce.notification.controller.Notification;

import java.util.concurrent.Flow;

public class NotificationSubscription implements Flow.Subscription {

    private final NotificationPublisher publisher;
    private final Flow.Subscriber<? super Notification> subscriber;

    public NotificationSubscription(NotificationPublisher publisher, Flow.Subscriber<? super Notification> subscriber) {
        this.publisher = publisher;
        this.subscriber = subscriber;
    }

    @Override
    public void request(long size) {
        this.publisher.push(size);
    }

    @Override
    public void cancel() {
        this.publisher.unsubscribe(subscriber);
    }
}

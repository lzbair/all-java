package com.ecommerce.notification;

import java.util.concurrent.Flow;

public class NotificationPublisher implements Flow.Publisher<Notification> {

    @Override
    public void subscribe(Flow.Subscriber<? super Notification> subscriber) {
        try {
            NotificationSubscription subscription = new NotificationSubscription();
            subscriber.onSubscribe(subscription);
        } catch (Exception e) {
            subscriber.onError(e);
        }
    }
}

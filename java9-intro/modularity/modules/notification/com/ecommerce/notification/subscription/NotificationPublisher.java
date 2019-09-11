package com.ecommerce.notification.subscription;

import com.ecommerce.notification.controller.Notification;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class NotificationPublisher implements Flow.Publisher<Notification> {

    private final List<Flow.Subscriber> subscribers = new ArrayList<>();
    private final List<Notification> notifications = new ArrayList<>();

    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        subscribers.add(subscriber);
        NotificationSubscription subscription = new NotificationSubscription(this, subscriber);
        try {
            subscriber.onSubscribe(subscription);
        } catch (RuntimeException e) {
            subscriber.onError(e);
            subscription.cancel();
        }
    }


    public void submit(Notification notification) {
        notifications.add(notification);
    }

    public void push(Notification notification) {
        subscribers.forEach(
                s -> s.onNext(notification)
        );
    }

    public void push(long size) {
        subscribers.forEach(
                s -> this.notifications.stream().limit(size).forEach(s::onNext)
        );
    }

    public void unsubscribe(Flow.Subscriber<? super Notification> subscriber) {
        this.subscribers.remove(subscriber);
    }
}

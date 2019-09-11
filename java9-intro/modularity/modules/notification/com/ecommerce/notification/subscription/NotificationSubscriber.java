package com.ecommerce.notification.subscription;

import com.ecommerce.notification.controller.Notification;

import java.util.concurrent.Flow;

public class NotificationSubscriber implements Flow.Subscriber<Notification> {
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        subscription.request(100);
    }

    @Override
    public void onNext(Notification notification) {
        System.out.println(getClass().getName() + ": New notification pushed: " + notification);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(getClass().getName() + ": Error occurred during push notification: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        //
    }
}

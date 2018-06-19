package com.ecommerce.notification;

import java.util.concurrent.Flow;

public class NotificationSubscriber1 implements Flow.Subscriber<Notification> {
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        subscription.request(100);
    }

    @Override
    public void onNext(Notification notification) {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}

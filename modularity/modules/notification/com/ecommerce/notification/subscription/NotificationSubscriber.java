package com.ecommerce.notification.subscription;

import com.ecommerce.notification.controller.Notification;

import java.util.function.Consumer;

public class NotificationSubscriber implements Consumer<Notification> {

    @Override
    public void accept(Notification notification) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getClass().getName() + ": New notification pushed: " + notification);
    }
}

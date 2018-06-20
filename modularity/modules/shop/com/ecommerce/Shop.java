package com.ecommerce;

import com.ecommerce.delivery.Delivery;
import com.ecommerce.delivery.DeliveryZone;
import com.ecommerce.notification.controller.Notification;
import com.ecommerce.notification.controller.NotificationController;
import com.service.toolkit.Sort;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;


public class Shop {

    private final NotificationController notificationController = new NotificationController();

    public static void main(String... args) throws Exception {
        new Shop().run();
    }

    public void run() throws Exception {
        join("com.toolkit.monitor.Aspect", "before");

        final Delivery delivery = new Delivery();
        System.out.println("Delivery says: " + delivery.greet());
        System.out.println("Adderess says: " + delivery.address());
        List<DeliveryZone> zones = Sort.lookup().<DeliveryZone>sort(delivery.zones());
        System.out.println("Sorted delivery zones: " + zones);

        sendNotification(zones);

        join("com.toolkit.monitor.Aspect", "after");


        exit();

    }

    private void exit() {
        Scanner in = new Scanner(System.in);
        System.out.println("Press q to exit !");
        while (true) {
            if (in.nextLine().equalsIgnoreCase("q")) {
                break;
            }
        }
    }

    private void join(String proxy, String stage) throws Exception {
        Class aspect = Class.forName(proxy);
        Method m = aspect.getDeclaredMethod(stage, String.class);
        m.setAccessible(true);
        m.invoke(null, "Shopping ...");
    }

    private void sendNotification(List<DeliveryZone> zones) {
        Notification notification = new Notification("Delivery", zones);
        notificationController.doNotify(notification);
    }
} 
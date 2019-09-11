package com.ecommerce.notification.controller;

import java.util.Objects;

public class Notification<DATA> {

    private final String name;
    private final DATA data;

    public Notification(String name, DATA data) {
        this.name = name;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "name='" + name + '\'' +
                ", data=" + data.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification<?> that = (Notification<?>) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

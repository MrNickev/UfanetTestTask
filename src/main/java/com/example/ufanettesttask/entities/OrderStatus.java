package com.example.ufanettesttask.entities;

public enum OrderStatus {
    REGISTERED("registered", 1),
    CANCELED("canceled", 2),
    IN_WORK("in-work", 3),
    READY("ready", 4),
    RECEIVED("received", 5);
    private final String text;
    private final int value;

    OrderStatus(final String text, int value) {
        this.text = text;
        this.value = value;
    }

    @Override
    public String toString() {
        return text;
    }

    public  int compare(OrderStatus that) {
        return Integer.compare(this.value, that.value);
    }
}

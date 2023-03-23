package com.example.kafka.streams.poc.common.util;

public enum PaymentOrderStatus {

    UNKNOWN("Unknown"),
    PENDING("Payment pending"),
    CANCELLED("Payment cancelled");

    public String type;

    PaymentOrderStatus(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

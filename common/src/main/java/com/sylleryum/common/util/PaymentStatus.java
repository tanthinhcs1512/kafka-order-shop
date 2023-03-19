package com.sylleryum.common.util;

public enum PaymentStatus {

    COMPLETED("Completed"),
    CANCELLED("Cancelled"),
    FAILED("Failed");

    public String type;

    PaymentStatus(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

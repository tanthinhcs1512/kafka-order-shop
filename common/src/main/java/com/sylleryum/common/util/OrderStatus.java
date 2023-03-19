package com.sylleryum.common.util;

public enum OrderStatus {

    NEW("New"),
    PENDING("Pending"),
    PAID("Paid"),
    ORDER_CONFIRMED("Order Confirmed"),
    CANCELLING("Cancelling"),
    SUCCESS("Success"),
    FAILED("Failed"),
    ROLLBACK("Rollback"),
    CANCELLED("Cancelled");

    public String type;

    OrderStatus(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

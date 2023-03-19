package com.sylleryum.common.util;

public enum StockStatus {

    UNKNOWN("Unknown"),
    NOT_PAID("Not paid");

    public String type;

    StockStatus(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

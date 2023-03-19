package com.sylleryum.common.util;

public enum OrderApprovalStatus {

    APPROVED("Approved"),
    REJECTED("Rejected");

    public String type;

    OrderApprovalStatus(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

package com.example.ufanettesttask.events;

public class CancelOrderEvent extends OrderEvent{
    private String reason;

    public CancelOrderEvent() {
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "CancelOrderEvent{" +
                "orderId='" + getOrderId() + "' " +
                "employeeId='" + getEmployeeId() + "' " +
                "reason='" + reason + "' " +
                '}';
    }
}

package com.example.ufanettesttask.events;

import lombok.*;
import java.time.LocalDateTime;

public abstract class OrderEvent {


    private transient Integer orderId;


    private transient Integer employeeId;

    @Builder.Default
    private final transient LocalDateTime date = LocalDateTime.now();


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "OrderEvent{" +
                "orderId=" + orderId +
                ", employeeId=" + employeeId +
                ", date=" + date +
                '}';
    }
}

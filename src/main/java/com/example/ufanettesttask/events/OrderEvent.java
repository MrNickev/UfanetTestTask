package com.example.ufanettesttask.events;

import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.lang.NonNull;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;

public abstract class OrderEvent {


    private transient Integer orderId;


    private transient Integer employeeId;

    @Builder.Default
    private transient LocalDateTime date = LocalDateTime.now();


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

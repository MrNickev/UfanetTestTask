package com.example.ufanettesttask.events;

import java.time.LocalDateTime;

public class RegisterOrderEvent extends OrderEvent {
    private Integer clientId;
    private LocalDateTime expectedDeliveryTime;
    private Integer productId;
    private Float price;


    public RegisterOrderEvent() {
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getExpectedDeliveryTime() {
        return expectedDeliveryTime;
    }

    public void setExpectedDeliveryTime(LocalDateTime expectedDeliveryTime) {
        this.expectedDeliveryTime = expectedDeliveryTime;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RegisterOrderEvent{" +
                "orderId=" + getOrderId() +
                "clientId=" + clientId +
                ", employeeId=" + getEmployeeId() +
                ", date=" + getDate() +
                '}';
    }
}

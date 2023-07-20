package com.example.ufanettesttask.dto;

import com.example.ufanettesttask.entities.OrderEventEntity;
import com.example.ufanettesttask.entities.OrderStatus;

import java.util.List;

public class Order {
    public Integer orderId;
    public OrderStatus status;
    public List<OrderEventEntity> events;
}

package com.example.ufanettesttask.dto;

import com.example.ufanettesttask.entities.OrderEventEntity;
import com.example.ufanettesttask.entities.OrderStatus;
import com.example.ufanettesttask.events.OrderEvent;

import java.util.List;

public class Order {
    public Integer orderId;
    public String status;
//    public String otherInfo;
    public List<OrderEventEntity> events;
}

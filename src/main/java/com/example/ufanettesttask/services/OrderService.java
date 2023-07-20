package com.example.ufanettesttask.services;

import com.example.ufanettesttask.dto.Order;
import com.example.ufanettesttask.entities.OrderEventEntity;
import com.example.ufanettesttask.events.OrderEvent;

public interface OrderService {
    void publishEvent(OrderEvent orderEvent);

    Order findOrder(int id);
}

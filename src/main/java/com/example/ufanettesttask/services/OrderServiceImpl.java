package com.example.ufanettesttask.services;

import com.example.ufanettesttask.dto.Order;
import com.example.ufanettesttask.events.OrderEvent;
import com.example.ufanettesttask.repositories.OrderEventRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    private final ApplicationEventPublisher publisher;
    private final OrderEventRepository repository;
    public OrderServiceImpl(ApplicationEventPublisher publisher, OrderEventRepository repository) {
        this.publisher = publisher;
        this.repository = repository;
    }

    @Override
    public void publishEvent(OrderEvent orderEvent) {
        if (orderEvent.getOrderId() == null || orderEvent.getEmployeeId() == null)
            throw new IllegalArgumentException("Поля orderId и employeeId обязательны для заполнения");
        publisher.publishEvent(orderEvent);
    }

    @Override
    public Order findOrder(int id) {
        var events = repository.findAllByOrderId(id);
        if (events.size() == 0)
            return null;

        var order = new Order();
        order.orderId = id;
        order.status = events.stream().max((e1, e2) -> e1.getStatus().compare(e2.getStatus())).get().getStatus().toString();
        order.events = events;
        return order;
    }
}

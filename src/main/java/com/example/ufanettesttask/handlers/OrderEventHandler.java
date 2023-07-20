package com.example.ufanettesttask.handlers;

import com.example.ufanettesttask.entities.OrderEventEntity;
import com.example.ufanettesttask.entities.OrderStatus;
import com.example.ufanettesttask.events.*;
import com.example.ufanettesttask.json.LocalDateTimeJsonAdapter;
import com.example.ufanettesttask.repositories.OrderEventRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Slf4j
@Component
public class OrderEventHandler {

    private final OrderEventRepository repository;
    private final Gson gson;

    public OrderEventHandler(OrderEventRepository repository) {
        this.repository = repository;
        gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeJsonAdapter().nullSafe()).create();

    }

    @EventListener
    public void handle(RegisterOrderEvent event) {
        log.info("Handle in register handle: " + event.toString());
        if (repository.findAllByOrderId(event.getOrderId()).stream().anyMatch(orderEventEntity -> orderEventEntity.getStatus() == OrderStatus.REGISTERED))
            throw new IllegalArgumentException("Заказ уже зарегистрирован");
        var orderEvent = new OrderEventEntity(event.getOrderId(), event.getEmployeeId(), OrderStatus.REGISTERED, event.getDate());
        orderEvent.setOtherInfo(gson.toJson(event));
        repository.save(orderEvent);
    }

    @EventListener
    public void handle(CancelOrderEvent event) {
        log.info("Handle in cancel handle: " + event.toString());
        checkForRegistrationAndCancelAndReceived(event.getOrderId());

        var orderEvent = new OrderEventEntity(event.getOrderId(), event.getEmployeeId(), OrderStatus.CANCELED, event.getDate());
        orderEvent.setOtherInfo(gson.toJson(event));
        repository.save(orderEvent);
    }

    @EventListener
    public void handle(InWorkOrderEvent event) {
        log.info("Handle in in-work handle: " + event.toString());
        checkForRegistrationAndCancelAndReceived(event.getOrderId());
        var orderEvent = new OrderEventEntity(event.getOrderId(), event.getEmployeeId(), OrderStatus.IN_WORK, event.getDate());
        orderEvent.setOtherInfo(gson.toJson(event));
        repository.save(orderEvent);
    }

    @EventListener
    public void handle(ReadyOrderEvent event) {
        log.info("Handle in in-work handle: " + event.toString());
        checkForRegistrationAndCancelAndReceived(event.getOrderId());
        var orderEvent = new OrderEventEntity(event.getOrderId(), event.getEmployeeId(), OrderStatus.READY, event.getDate());
        orderEvent.setOtherInfo(gson.toJson(event));
        repository.save(orderEvent);
    }

    @EventListener
    public void handle(ReceivedOrderEvent event) {
        log.info("Handle in in-work handle: " + event.toString());
        checkForRegistrationAndCancelAndReceived(event.getOrderId());
        var orderEvent = new OrderEventEntity(event.getOrderId(), event.getEmployeeId(), OrderStatus.RECEIVED, event.getDate());
        orderEvent.setOtherInfo(gson.toJson(event));
        repository.save(orderEvent);
    }



    public OrderStatus checkForRegistrationAndCancelAndReceived(Integer orderId) {
        var registrationEvents = repository.findAllByOrderId(orderId);
        OrderStatus status;
        if (registrationEvents.stream().filter(orderEventEntity -> orderEventEntity.getStatus() == OrderStatus.REGISTERED).findAny().isEmpty())
            throw new IllegalArgumentException("Заказ должен быть зарегистрирован");
        else status = OrderStatus.REGISTERED;

        if (registrationEvents.stream().anyMatch(orderEventEntity -> orderEventEntity.getStatus() == OrderStatus.CANCELED))
            throw new IllegalArgumentException("Заказ отменен");

        if (registrationEvents.stream().anyMatch(orderEventEntity -> orderEventEntity.getStatus() == OrderStatus.RECEIVED))
            throw new IllegalArgumentException("Заказ уже получен");

        return status;
    }





}

package com.example.ufanettesttask.conrollers;

import com.example.ufanettesttask.dto.Order;
import com.example.ufanettesttask.events.*;
import com.example.ufanettesttask.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public void registerOrder(@RequestBody RegisterOrderEvent registerOrderEvent) {
        log.info("Event " + registerOrderEvent.toString() + " get for registration");
        service.publishEvent(registerOrderEvent);
    }

    @PostMapping("/cancel")
    public void cancelOrder(@RequestBody CancelOrderEvent cancelOrderEvent) {
        log.info("Event " + cancelOrderEvent.toString() + " get for canceling");
        service.publishEvent(cancelOrderEvent);
    }
    @PostMapping("/in_work")
    public void orderInWork(@RequestBody InWorkOrderEvent workingOrderEvent) {
        log.info("Event " + workingOrderEvent.toString() + " get for woking");
        service.publishEvent(workingOrderEvent);
    }
    @PostMapping("/ready")
    public void readyOrder(@RequestBody ReadyOrderEvent readyOrderEvent) {
        log.info("Event " + readyOrderEvent.toString() + " get for ready");
        service.publishEvent(readyOrderEvent);
    }
    @PostMapping("/receive")
    public void receiveOrder(@RequestBody ReceivedOrderEvent receivedOrderEvent) {
        log.info("Event " + receivedOrderEvent.toString() + " get for receiving");
        service.publishEvent(receivedOrderEvent);
    }

    @GetMapping("/get-info/{id}")
    public Order getOrderInfo(@PathVariable Integer id) {
        return service.findOrder(id);
    }
}

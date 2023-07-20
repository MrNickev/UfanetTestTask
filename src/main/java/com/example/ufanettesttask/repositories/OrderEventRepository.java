package com.example.ufanettesttask.repositories;

import com.example.ufanettesttask.entities.OrderEventEntity;
import com.example.ufanettesttask.events.OrderEvent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderEventRepository extends CrudRepository<OrderEventEntity, Long> {
    public List<OrderEventEntity> findAllByOrderId(Integer orderId);
}

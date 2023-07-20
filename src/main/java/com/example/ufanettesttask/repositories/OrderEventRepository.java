package com.example.ufanettesttask.repositories;

import com.example.ufanettesttask.entities.OrderEventEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderEventRepository extends CrudRepository<OrderEventEntity, Long> {
    List<OrderEventEntity> findAllByOrderId(Integer orderId);
}

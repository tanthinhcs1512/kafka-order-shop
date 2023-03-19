package com.sylleryum.order.service;

import com.sylleryum.order.entity.Order;
import com.sylleryum.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order save(Order orderDAO){
        return orderRepository.save(orderDAO);
    }

    public <S extends Order> Iterable<S> saveAll(Iterable<S> entities) {
        return orderRepository.saveAll(entities);
    }

    public Optional<Order> findByOrderNumber(String orderNumber) {
        return orderRepository.findByOrderNumber(orderNumber);
    }
}

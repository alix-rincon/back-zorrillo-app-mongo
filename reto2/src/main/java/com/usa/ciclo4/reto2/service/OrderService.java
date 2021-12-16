package com.usa.ciclo4.reto2.service;

import java.util.List;
import java.util.Optional;

import com.usa.ciclo4.reto2.model.Order;
import com.usa.ciclo4.reto2.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    public Order create(Order order) {
        Optional<Order> orderIdMax = orderRepository.lastOrderId();
        if (order.getId() == null) {
            if (orderIdMax.isEmpty()) {
                order.setId(1);
            } else {
                order.setId(orderIdMax.get().getId() + 1);
            }
        }
        Optional<Order> orderId = orderRepository.getOrder(order.getId());
        if (orderId.isEmpty()) {
            return orderRepository.create(order);
        } else {
            return order;
        }
    }

    public Order update(Order order) {
        if (order.getId() != null) {
            Optional<Order> orderData = orderRepository.getOrder(order.getId());
            if (!orderData.isEmpty()) {
                if (order.getStatus() != null) {
                    orderData.get().setStatus(order.getStatus());
                }
                orderRepository.update(orderData.get());
                return orderData.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getOrder(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Order> findByZone(String zona) {
        return orderRepository.findByZone(zona);
    }

}

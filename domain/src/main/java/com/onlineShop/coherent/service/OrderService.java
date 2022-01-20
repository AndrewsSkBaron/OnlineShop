package com.onlineShop.coherent.service;

import com.onlineShop.coherent.repository.OrderRepository;
import com.onlineShop.coherent.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order save(Order order) {
        orderRepository.save(order);
        return order;
    }

    public List<Order> getOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    public void delete() {
        orderRepository.deleteAll();
    }

}

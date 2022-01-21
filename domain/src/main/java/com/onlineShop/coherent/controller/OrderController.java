package com.onlineShop.coherent.controller;

import com.onlineShop.coherent.service.OrderService;
import com.onlineShop.coherent.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public void createOrder(@RequestBody Order order) {
        orderService.save(order);
    }

    @GetMapping("/order")
    public ResponseEntity getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }

    @DeleteMapping("/order")
    public HttpStatus delete() {
        orderService.delete();
        return HttpStatus.OK;

    }


}

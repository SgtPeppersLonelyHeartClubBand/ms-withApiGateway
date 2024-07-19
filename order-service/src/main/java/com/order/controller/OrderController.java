package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.order.model.Order;
import com.order.service.OrderService;


@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        boolean customerExists = orderService.checkCustomerExists(order.getCustomerId());
        if (customerExists) {
            orderService.saveOrder(order);
            return ResponseEntity.ok("Order created successfully");
        } else {
            return ResponseEntity.status(400).body("Customer does not exist");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
}

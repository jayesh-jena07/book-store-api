package com.example.bookstore_api.controller;

import com.example.bookstore_api.model.Order;
import com.example.bookstore_api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        Order savedOrder = orderService.placeOrder(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrder(){
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/history/{username}")
    public ResponseEntity<List<Order>> getOrderHistory(@PathVariable String username) {
        List<Order> orders = orderService.getOrderHistory(username);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}

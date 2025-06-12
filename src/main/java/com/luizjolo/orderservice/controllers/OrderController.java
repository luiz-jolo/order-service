package com.luizjolo.orderservice.controllers;


import com.luizjolo.orderservice.domain.order.dtos.CreateOrderDto;
import com.luizjolo.orderservice.domain.order.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid CreateOrderDto createOrderDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(createOrderDto));
    }

}

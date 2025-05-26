package com.luizjolo.orderservice.domain.order.services.impl;

import com.luizjolo.orderservice.domain.order.Order;
import com.luizjolo.orderservice.domain.order.OrderRepository;
import com.luizjolo.orderservice.domain.order.dtos.CreateOrderDto;
import com.luizjolo.orderservice.domain.order.services.OrderService;
import com.luizjolo.orderservice.domain.validators.CreateOrderValidator;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(CreateOrderDto createOrderDto) {
        CreateOrderValidator.validate(createOrderDto);
        var order = new Order(createOrderDto.asset(), createOrderDto.userId(), createOrderDto.amount());
        orderRepository.save(order);
        return order;
    }

}

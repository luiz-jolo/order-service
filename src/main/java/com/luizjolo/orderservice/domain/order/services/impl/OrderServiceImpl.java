package com.luizjolo.orderservice.domain.order.services.impl;

import com.luizjolo.orderservice.amqp.OrderEventPublisher;
import com.luizjolo.orderservice.domain.order.Order;
import com.luizjolo.orderservice.domain.order.OrderRepository;
import com.luizjolo.orderservice.domain.order.dtos.CreateOrderDto;
import com.luizjolo.orderservice.domain.order.dtos.OrderEventDto;
import com.luizjolo.orderservice.domain.order.services.OrderService;
import com.luizjolo.orderservice.domain.validators.CreateOrderValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderEventPublisher orderEventPublisher;

    public OrderServiceImpl(OrderRepository orderRepository, OrderEventPublisher orderEventPublisher){
        this.orderRepository = orderRepository;
        this.orderEventPublisher = orderEventPublisher;
    }

    @Transactional
    @Override
    public Order create(CreateOrderDto createOrderDto) {
        CreateOrderValidator.validate(createOrderDto);
        var order = new Order(createOrderDto.asset(), createOrderDto.userId(), createOrderDto.amount());

        orderRepository.save(order);

        orderEventPublisher.publishOrderEvent(new OrderEventDto(
                "123456",
                createOrderDto.asset().toString(),
                createOrderDto.amount().toString(),
                "created"));

        return order;
    }

}

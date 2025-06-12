package com.luizjolo.orderservice.domain.order.services;

import com.luizjolo.orderservice.domain.order.Order;
import com.luizjolo.orderservice.domain.order.dtos.CreateOrderDto;

public interface OrderService {
    public Order create(CreateOrderDto createOrderDto);
}

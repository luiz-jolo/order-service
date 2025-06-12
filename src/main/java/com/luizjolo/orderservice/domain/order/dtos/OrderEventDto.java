package com.luizjolo.orderservice.domain.order.dtos;

public record OrderEventDto(
    String orderId,
    String asset,
    String amount,
    String status
) {
}

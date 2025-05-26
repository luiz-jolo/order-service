package com.luizjolo.orderservice.domain.order.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateOrderDto(

        @NotNull(message = "UserId is mandatory")
        Long userId,

        @NotBlank(message = "Asset is mandatory")
        String asset,

        @NotNull(message = "Amount is mandatory")
        java.math.BigDecimal amount
){}
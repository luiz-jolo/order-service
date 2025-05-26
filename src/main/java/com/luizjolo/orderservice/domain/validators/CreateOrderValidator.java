package com.luizjolo.orderservice.domain.validators;

import com.luizjolo.orderservice.domain.order.dtos.CreateOrderDto;
import jakarta.validation.ValidationException;

import java.math.BigDecimal;

public class CreateOrderValidator {

    public static void validate(CreateOrderDto dto){

        if (dto.amount().compareTo(BigDecimal.ZERO) < 0) {
            throw new ValidationException("Amount must not be negative");
        }

    }

}

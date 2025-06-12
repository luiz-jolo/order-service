package com.luizjolo.orderservice.amqp;

import com.luizjolo.orderservice.domain.order.dtos.OrderEventDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderEventPublisher {

    final RabbitTemplate rabbitTemplate;
    final String exchangeName = "order";

    public OrderEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishOrderEvent(OrderEventDto orderEventDto){
        rabbitTemplate.convertAndSend(exchangeName, "", orderEventDto);
    }

}

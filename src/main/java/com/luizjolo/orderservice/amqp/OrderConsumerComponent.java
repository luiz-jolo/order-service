package com.luizjolo.orderservice.amqp;

import com.luizjolo.orderservice.domain.order.dtos.OrderEventDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumerComponent {

    @RabbitListener(queues = "order.queue")
    public void handleOrderEvent(OrderEventDto orderEventDto){
        System.out.println("Recebimento de order");
        System.out.println("orderId " + orderEventDto.orderId());
        System.out.println("amount " + orderEventDto.amount() );
        System.out.println("asset " + orderEventDto.asset());
        System.out.println("status " + orderEventDto.status());
    }

}

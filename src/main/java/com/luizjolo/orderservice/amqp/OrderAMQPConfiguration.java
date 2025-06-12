package com.luizjolo.orderservice.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderAMQPConfiguration {

//    @Bean
//    public Queue createOrderQueue(){
//         return QueueBuilder.nonDurable("order").build();
//    }
//
//    @Bean
//    public RabbitAdmin createRabbitAdmin(ConnectionFactory conn){
//        return new RabbitAdmin(conn);
//    }
//
//    //quando inicia a aplicaço, cria a fila no rabbit
//    @Bean
//    public ApplicationListener<ApplicationReadyEvent> initializeAdmin(RabbitAdmin rabbitAdmin){
//        return event -> rabbitAdmin.initialize();
//    }



}

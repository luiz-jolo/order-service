package com.luizjolo.orderservice.domain.order;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public class Order {

    private UUID id;
    private String asset;

//    id SERIAL PRIMARY KEY,
//    user_id BIGINT NOT NULL,
//    asset VARCHAR(10) NOT NULL,
//    amount DECIMAL(18,8) NOT NULL,
//    status VARCHAR(50) NOT NULL,
//    created_at TIMESTAMP DEFAULT NOW()

//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private Long id;
//
//    private String asset;


}

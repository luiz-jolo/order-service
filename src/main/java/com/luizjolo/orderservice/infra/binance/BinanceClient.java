package com.luizjolo.orderservice.infra.binance;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BinanceClient {

    private final WebClient webClient;

    public BinanceClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://api.binance.com").build();
    }

    public BinanceAssetResponse getAsset(String symbol) {
        return webClient.get()
                .uri("/api/v3/exchangeInfo?symbol=" + symbol)
                .retrieve()
                .bodyToMono(BinanceAssetResponse.class)
                .block();
    }

}

package com.luizjolo.orderservice.domain.asset;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/assets")
public class AssetController {

    private final String BINANCE_API_URL = "https://api.binance.com/api/v3/ticker/price?symbol=";

    @GetMapping
    ResponseEntity getAssetInBinance(){
        var symbol = "BTCUSDT";

        RestTemplate restTemplate = new RestTemplate();

        try {
            String url = BINANCE_API_URL + symbol.toUpperCase();
            ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "Erro ao buscar dados do ativo"));
        }
    }

}

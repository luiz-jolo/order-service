package com.luizjolo.orderservice.domain.asset.services;

import com.luizjolo.orderservice.domain.asset.Asset;
import com.luizjolo.orderservice.domain.asset.dtos.SaveAssetDto;

import java.util.Optional;

public interface AssetService {


    Optional<Asset> findBySymbol(String symbol);
    Asset save(SaveAssetDto saveAssetDto);
}

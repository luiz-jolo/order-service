package com.luizjolo.orderservice.domain.asset.services.impl;

import com.luizjolo.orderservice.domain.asset.Asset;
import com.luizjolo.orderservice.domain.asset.dtos.SaveAssetDto;
import com.luizjolo.orderservice.domain.asset.repositories.AssetRepository;
import com.luizjolo.orderservice.domain.asset.services.AssetService;

import java.util.Optional;

public class AssetServiceImpl implements AssetService {

    private AssetRepository assetRepository;

    public AssetServiceImpl(AssetRepository assetRepository){
        this.assetRepository = assetRepository;
    }

    @Override
    public Optional<Asset> findBySymbol(String symbol) {
        //...
        return Optional.empty();
    }

    @Override
    public Asset save(SaveAssetDto saveAssetDto) {
        return null;
    }
}

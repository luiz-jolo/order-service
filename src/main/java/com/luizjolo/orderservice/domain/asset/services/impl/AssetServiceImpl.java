package com.luizjolo.orderservice.domain.asset.services.impl;

import com.luizjolo.orderservice.domain.asset.Asset;
import com.luizjolo.orderservice.domain.asset.services.AssetService;

import java.util.Optional;
import java.util.UUID;

public class AssetServiceImpl implements AssetService {

    @Override
    public Optional<Asset> findById(UUID id) {
        return Optional.empty();
    }
}

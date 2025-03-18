package com.luizjolo.orderservice.domain.asset.services;

import com.luizjolo.orderservice.domain.asset.Asset;

import java.util.Optional;
import java.util.UUID;

public interface AssetService {

    Optional<Asset> findById(UUID id);

}

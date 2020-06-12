package com.kairosds.service;

import com.kairosds.model.Prices;

import java.util.Optional;

public interface PricesService {
    Optional<Prices> getProductPriceForDate(String date, long productId, long brandId);
}

package com.kairosds.service;

import com.kairosds.model.Price;

import java.util.Optional;

public interface PricesService {
    Optional<Price> getProductPriceForDate(String date, long productId, long brandId);
}

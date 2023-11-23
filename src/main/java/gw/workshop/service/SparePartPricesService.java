package gw.workshop.service;

import gw.workshop.model.Price;

import java.util.Optional;

public interface PricesService {
    Optional<Price> getProductPriceForDate(String date, long productId);
}

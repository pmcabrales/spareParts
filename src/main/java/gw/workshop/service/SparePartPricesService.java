package gw.workshop.service;

import gw.workshop.model.Price;
import gw.workshop.model.SparePart;

import java.util.List;
import java.util.Optional;

public interface SparePartPricesService {
    Optional<Price> getProductPriceForDate(String date, long productId);

    List<SparePart> findSparePartsByVehicleAndType(String brandCode, String modelCode, String modelYear, String sparePartType);
}

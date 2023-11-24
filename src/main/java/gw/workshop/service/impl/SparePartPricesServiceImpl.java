package gw.workshop.service.impl;

import gw.workshop.model.Price;
import gw.workshop.model.SparePart;
import gw.workshop.repository.PricesRepository;
import gw.workshop.repository.SparePartsRepository;
import gw.workshop.service.SparePartPricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class SparePartPricesServiceImpl implements SparePartPricesService {

    @Autowired
    private PricesRepository pricesRepository;
    @Autowired
    private SparePartsRepository sparePartsRepository;

    public Optional<Price> getProductPriceForDate(String date, long productId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        Price price = pricesRepository.findFirstByProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(productId, dateTime, dateTime);

        return Optional.ofNullable(price);
    }


    public List<SparePart> findSparePartsByVehicleAndType(String brandCode, String modelCode, String modelYear, String sparePartType) {
        List<SparePart> spareParts = sparePartsRepository.findAllByBrandCodeAndModelCodeAndModelYearAndSparePartType(brandCode,modelCode,modelYear,sparePartType);
        return spareParts;
    }
}

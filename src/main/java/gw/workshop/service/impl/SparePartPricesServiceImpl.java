package gw.workshop.service.impl;

import gw.workshop.model.Price;
import gw.workshop.repository.PricesRepository;
import gw.workshop.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class PricesServiceImpl implements PricesService {

    @Autowired
    private PricesRepository pricesRepository;

    public Optional<Price> getProductPriceForDate(String date, long productId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        Price price = pricesRepository.findFirstByProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(productId, dateTime, dateTime);

        return Optional.ofNullable(price);
    }
}

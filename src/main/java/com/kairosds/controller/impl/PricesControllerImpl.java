package com.kairosds.controller.impl;

import com.kairosds.controller.PricesController;
import com.kairosds.model.Prices;
import com.kairosds.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class PricesControllerImpl implements PricesController {

    @Autowired
    private PricesService pricesService;

    @GetMapping("/prices")
    @ResponseStatus(HttpStatus.OK)
    public Prices getProductPrice(@RequestParam String date, @RequestParam long productId, @RequestParam long brandId){
        Optional<Prices> prices = pricesService.getProductPriceForDate(date,productId,brandId);
        if (!prices.isPresent()) throw new NoSuchElementException();
        return prices.get();
     }

}

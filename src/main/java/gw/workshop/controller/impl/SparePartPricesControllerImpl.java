package gw.workshop.controller.impl;

import gw.workshop.controller.PricesController;
import gw.workshop.model.Price;
import gw.workshop.service.SparePartPricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class PricesControllerImpl implements PricesController {

    @Autowired
    private SparePartPricesService sparePartPricesService;

    @GetMapping("/prices")
    @ResponseStatus(HttpStatus.OK)
    public Price getProductPrice(@RequestParam String date, @RequestParam long productId){
        Optional<Price> prices = sparePartPricesService.getProductPriceForDate(date,productId);
        if (!prices.isPresent()) throw new NoSuchElementException();
        return prices.get();
     }

}

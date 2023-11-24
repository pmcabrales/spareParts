package gw.workshop.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gw.workshop.controller.SparePartPricesController;
import gw.workshop.model.Price;
import gw.workshop.model.SparePart;
import gw.workshop.service.SparePartPricesService;
import io.swagger.annotations.ResponseHeader;
import io.swagger.models.Xml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class SparePartPricesControllerImpl implements SparePartPricesController {

    @Autowired
    private SparePartPricesService sparePartPricesService;

    @GetMapping("/prices")
    @ResponseStatus(HttpStatus.OK)
    public String getProductPrice(@RequestParam String date, @RequestParam long productId){
        Optional<Price> prices = sparePartPricesService.getProductPriceForDate(date,productId);
        if (!prices.isPresent()) throw new NoSuchElementException();
        return prices.get().toString();
     }

    @GetMapping(value = "/spareParts")
    @ResponseStatus(HttpStatus.OK)
    public
    String getSpareParts(@RequestParam String brandCode, @RequestParam String modelCode, @RequestParam String modelYear, @RequestParam String sparePartType){
        List<SparePart> sparePartList = sparePartPricesService.findSparePartsByVehicleAndType(brandCode,modelCode,modelYear,sparePartType);
        if (sparePartList.size()==0) throw new NoSuchElementException();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonArray = "";
        try {
            jsonArray = objectMapper.writeValueAsString(sparePartList);
        }catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return jsonArray;
    }

}

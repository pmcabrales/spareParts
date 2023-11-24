package gw.workshop.controller;

import gw.workshop.model.Price;
import gw.workshop.model.SparePart;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api
public interface SparePartPricesController {
    @ApiOperation(value = "Get product price")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product Price"),
            @ApiResponse(code = 404, message = "Product not found"),
            @ApiResponse(code = 400, message = "Bad request: Possibly is missing a request attribute")})
    String getProductPrice(
            @ApiParam(value = "Date of the price for the product", format = "yyyy-MM-dd-HH.mm.ss", required = true) String date,
            @ApiParam(value = "Product id", required = true) long productId);

    @ApiOperation(value = "Get spare parts")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Spare parts"),
            @ApiResponse(code = 404, message = "Spare parts not found"),
            @ApiResponse(code = 400, message = "Bad request: Possibly is missing a request attribute")})
    String getSpareParts(
            @ApiParam(value = "brandCode", required = true) String brandCode,
            @ApiParam(value = "modelCode", required = true) String modelCode,
            @ApiParam(value = "modelYear", required = true) String modelYear,
            @ApiParam(value = "SparePartType", required = true) String SparePartType);

}

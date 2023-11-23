package gw.workshop.controller;

import gw.workshop.model.Price;
import io.swagger.annotations.*;

@Api
public interface PricesController {
    @ApiOperation(value = "Get product price")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product Price"),
            @ApiResponse(code = 404, message = "Product not found"),
            @ApiResponse(code = 400, message = "Bad request: Possibly is missing a request attribute")})
    Price getProductPrice(
            @ApiParam(value = "Date of the price for the product", format = "yyyy-MM-dd-HH.mm.ss", required = true) String date,
            @ApiParam(value = "Product id", required = true) long productId);

}

package com.kairosds.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.kairosds.model.Prices;
import com.kairosds.service.PricesService;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
//@RunWith(SpringRunner.class)
public class PricesControllerIT {

    @Autowired
    protected MockMvc mockMvc;

    protected ObjectMapper objectMapper;

    @Autowired
    private PricesService pricesService;

    @Before
    public void initialize() {
        objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Test
    public void getPricesTest1() throws Exception {
        MockitoAnnotations.initMocks(this);

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                .queryParam("date","2020-06-14-10.00.00")
                .queryParam("productId","35455")
                .queryParam("brandId","1")
                .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        DocumentContext result = JsonPath.parse(response.getContentAsString());

        int productId = result.read("productId");
        int brandId = result.read("brandId");
        int priceList = result.read("priceList");

        assertEquals(HttpStatus.OK, HttpStatus.valueOf(response.getStatus()));
        assertEquals(35455,productId);
        assertEquals(1,brandId);
        assertEquals(1,priceList);

    }



    /*         Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
            -          Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
            -          Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
            -          Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
            -          Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)

     */
}

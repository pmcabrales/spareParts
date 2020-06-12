package com.kairosds.controller;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.kairosds.service.PricesService;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class PricesControllerIT {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private PricesService pricesService;

    @Test
    public void getPricesTest1() throws Exception {
        getPricesTest("2020-06-14-10.00.00", 1);
    }

    @Test
    public void getPricesTest2() throws Exception {
        getPricesTest("2020-06-14-16.00.00", 2);
    }

    @Test
    public void getPricesTest3() throws Exception {
        getPricesTest("2020-06-14-21.00.00", 1);
    }

    @Test
    public void getPricesTest4() throws Exception {
        getPricesTest("2020-06-15-10.00.00", 3);
    }

    @Test
    public void getPricesTest5() throws Exception {
        getPricesTest("2020-06-16-21.00.00", 4);
    }


    private void getPricesTest(String date, int expectedPriceList) throws Exception {
        MockitoAnnotations.initMocks(this);

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                .queryParam("date",date)
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
        assertEquals(expectedPriceList,priceList);
    }

    @Test
    public void getPricesNotFound() throws Exception {
        MockitoAnnotations.initMocks(this);

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                .queryParam("date","2020-06-14-21.00.00")
                .queryParam("productId","-1")
                .queryParam("brandId","1")
                .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertEquals(HttpStatus.NOT_FOUND, HttpStatus.valueOf(response.getStatus()));
    }

    @Test
    public void getPricesBadRequest() throws Exception {
        MockitoAnnotations.initMocks(this);

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                .queryParam("brandId","1")
                .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertEquals(HttpStatus.BAD_REQUEST, HttpStatus.valueOf(response.getStatus()));
    }

}

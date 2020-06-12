package com.kairosds.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@ApiModel(description = "Entry of the blog")
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long priceId;

    @ApiModelProperty(notes = "Store group foreign key (1 = ZARA)")
    private long brandId;
    @ApiModelProperty(notes = "Date when the price starts to apply for the product")
    private LocalDateTime startDate;
    @ApiModelProperty(notes = "Date when the price ends to apply for the product")
    private LocalDateTime endDate;
    @ApiModelProperty(notes = "Applied fare id")
    private long priceList;
    @ApiModelProperty(notes = "Product code id")
    private long productId;
    @ApiModelProperty(notes = "Tiebreaker. If two fares applies at the same time the one with more priority is selected (numeric)")
    private int priority;
    @ApiModelProperty(notes = "Final price")
    private float price;
    @ApiModelProperty(notes = "Currency ISO")
    private String curr;

    public Prices() {
    }

    public Prices(long brandId, LocalDateTime startDate, LocalDateTime endDate, long priceList, long productId, int priority, long price, String curr) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
    }

    public long getPriceId() {
        return priceId;
    }

    public long getBrandId() {
        return brandId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public long getPriceList() {
        return priceList;
    }

    public long getProductId() {
        return productId;
    }

    public float getPrice() {
        return price;
    }

}

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

    @ApiModelProperty(notes = "foreign key de la cadena del grupo (1 = ZARA)")
    private long brandId;
    @ApiModelProperty(notes = "rango de fechas en el que aplica el precio tarifa indicado")
    private LocalDateTime startDate;
    @ApiModelProperty(notes = "rango de fechas en el que aplica el precio tarifa indicado")
    private LocalDateTime endDate;
    @ApiModelProperty(notes = "Identificador de la tarifa de precios aplicable")
    private long priceList;
    @ApiModelProperty(notes = "Identificador código de producto")
    private long productId;
    @ApiModelProperty(notes = "Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rago de fechas se aplica la de mayor prioridad (mayor valor numérico)")
    private int priority;
    @ApiModelProperty(notes = "precio final de venta")
    private float price;
    @ApiModelProperty(notes = "iso de la moneda")
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

    public void setPriceId(long priceId) {
        this.priceId = priceId;
    }

    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public long getPriceList() {
        return priceList;
    }

    public void setPriceList(long priceList) {
        this.priceList = priceList;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

}

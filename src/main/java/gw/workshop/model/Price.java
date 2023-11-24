package gw.workshop.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@ApiModel(description = "Entity for product prices over time")
@Table(name = "Prices")
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long priceId;

    @ApiModelProperty(notes = "Date when the price starts to apply for the product")
    @Getter
    private LocalDateTime startDate;
    @ApiModelProperty(notes = "Date when the price ends to apply for the product")
    @Getter
    private LocalDateTime endDate;
    @ApiModelProperty(notes = "Spare Part foreing key")
    @Getter
    private long productId;
    @ApiModelProperty(notes = "Tiebreaker. If two fares applies at the same time the one with more priority is selected (numeric)")
    private int priority;
    @ApiModelProperty(notes = "Final price")
    @Getter
    private float price;
    @ApiModelProperty(notes = "Currency ISO")
    private String curr;

    @Override
    public String toString() {
        return price + " " + curr;
    }
}

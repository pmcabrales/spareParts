package gw.workshop.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@ApiModel(description = "Entity for vehicles")
@Table(name = "Vehicle")
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long vehicleId;

    @ApiModelProperty(notes = "Vehicle brand code")
    private String brandCode;

    @ApiModelProperty(notes = "Vehicle model code")
    private String modelCode;

    @ApiModelProperty(notes = "Model Year")
    private int modelYear;
}

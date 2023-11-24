package gw.workshop.model;

import com.fasterxml.jackson.core.JsonParser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@ApiModel(description = "Entity for Spare Parts")
@Table(name = "SpareParts")
@NoArgsConstructor
@AllArgsConstructor
public class SparePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long vehicleId;

    @ApiModelProperty(notes = "Vehicle brand code")
    @Getter
    private String brandCode;

    @ApiModelProperty(notes = "Vehicle model code")
    @Getter
    private String modelCode;

    @ApiModelProperty(notes = "Model Year")
    @Getter
    private String modelYear;

    @ApiModelProperty(notes = "Spare part type")
    @Getter
    private String sparePartType;

    @ApiModelProperty(notes = "Spare part description")
    @Getter
    private String description;

}

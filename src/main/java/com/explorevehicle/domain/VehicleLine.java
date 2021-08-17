package com.explorevehicle.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@ApiModel(description = "All details about the VehicleLine.")
public class VehicleLine {

    @JsonProperty("MakeId")
    private Integer makeId;

    @JsonProperty("MakeName")
    private String nakeName;

    @JsonProperty("VehicleTypeId")
    private Integer vehicleTypeId;

    @JsonProperty("VehicleTypeName")
    private String vehicleTypeName;

}



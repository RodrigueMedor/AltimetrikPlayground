package com.explorevehicle.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@ApiModel(description = "All details about the Vehicle.")
public class Vehicle {

    @JsonProperty("Count")
    private int count;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("SearchCriteria")
    private String searchCriteria;

    @JsonAnyGetter
    @JsonProperty("Results")
    private List<VehicleLine> vehicleLines;
}

package com.explorevehicle.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleLineResponse {

    private Integer makeId;
    private Integer vehicleTypeId;
    private String vehicleTypeName;
}

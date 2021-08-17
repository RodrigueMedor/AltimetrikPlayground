package com.explorevehicle.mapper;

import com.explorevehicle.domain.VehicleLine;
import com.explorevehicle.dto.VehicleLineResponse;

public class VehicleLineResponseAdapter {

    public static VehicleLineResponse convert(VehicleLine vehicleLine) {

        return VehicleLineResponse.builder()
                .makeId(vehicleLine.getMakeId())
                .vehicleTypeName(vehicleLine.getVehicleTypeName())
                .vehicleTypeId(vehicleLine.getVehicleTypeId())
                .build();
    }
}

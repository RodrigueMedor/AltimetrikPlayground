package com.explorevehicle.controller;

import com.explorevehicle.dto.VehicleLineResponse;
import com.explorevehicle.service.VehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(value = "Operation on VehicleLine data",tags = "Vehicle Operations")
@RestController
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved group MakeName of vehicle data by VehicleTypeName"),
            @ApiResponse(code = 400, message = "No VehicleTypeName found.")
    })
    @ApiOperation(value = "Check if the dataType exist", response = String.class)
    @GetMapping("/vehicle/{vehicleTypeName}")
    public ResponseEntity<Map<String, List<VehicleLineResponse>>> groupingByVehicleByDataType(@PathVariable String vehicleTypeName) {
        ResponseEntity<Map<String, List<VehicleLineResponse>>>  mapResponseEntity = new ResponseEntity<>(vehicleService.groupingByVehicleByDataType(vehicleTypeName), HttpStatus.OK);
        return mapResponseEntity;
    }

}

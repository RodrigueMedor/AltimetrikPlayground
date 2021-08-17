package com.explorevehicle.exceptions;

public class VehicleNotFoundException extends RuntimeException {

    public VehicleNotFoundException(String dataType) {
        super(String.format("VehicleTypeName %s not found . ", dataType));
    }
}

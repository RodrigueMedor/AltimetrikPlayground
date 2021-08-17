package com.explorevehicle.service;

import com.explorevehicle.domain.Vehicle;
import com.explorevehicle.domain.VehicleLine;
import com.explorevehicle.dto.VehicleLineResponse;
import com.explorevehicle.mapper.VehicleLineResponseAdapter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;
    private final String URL = "https://vpic.nhtsa.dot.gov/api/vehicles/GetVehicleTypesForMake/merc?format=json";

    /*
    Retrieving vehicle by VehicleTypeName and grouping by vehicle MakeName.
    * */

    public Map<String, List<VehicleLineResponse>> groupingByVehicleByDataType(String vehicleTypeName) {
        Map<String, List<VehicleLineResponse>> results = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(headers);

        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        ResponseEntity<Vehicle> responseEntity =
                restTemplate.exchange(URL,
                        HttpMethod.GET, entity, new ParameterizedTypeReference<Vehicle>() {
                        });
        Vehicle vehicle = responseEntity.getBody();

        List<VehicleLine> vehicleLines = vehicle.getVehicleLines();

        List<VehicleLine> vehicleLineList = objectMapper.convertValue(vehicleLines, new TypeReference<List<VehicleLine>>() {
        });

        for (VehicleLine line : vehicleLineList) {
            List<VehicleLineResponse> vehicleLineResponses = new ArrayList<>();
            if (line.getVehicleTypeName().equals(vehicleTypeName)) {

                if (results.get(line.getNakeName()) == null) {
                    vehicleLineResponses.add(VehicleLineResponseAdapter.convert(line));
                    results.put(line.getNakeName(), vehicleLineResponses);
                } else {
                    vehicleLineResponses = results.get(line.getNakeName());
                    vehicleLineResponses.add(VehicleLineResponseAdapter.convert(line));
                    results.put(line.getNakeName(), vehicleLineResponses);
                }
            }
        }

        return results;
    }

}

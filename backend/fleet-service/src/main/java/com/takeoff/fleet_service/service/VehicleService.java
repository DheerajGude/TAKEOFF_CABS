package com.fleetservice.service;

import com.fleetservice.dto.VehicleRequest;
import com.fleetservice.dto.VehicleResponse;

import java.util.List;

public interface VehicleService {

    VehicleResponse addVehicle(VehicleRequest request);

    List<VehicleResponse> getAllVehicles();

    VehicleResponse getVehicleById(Long id);

    VehicleResponse updateVehicle(Long id, VehicleRequest request);

    void deleteVehicle(Long id);

    VehicleResponse changeAvailability(Long id, boolean available);

    VehicleResponse updateStatus(Long id, String status);
}

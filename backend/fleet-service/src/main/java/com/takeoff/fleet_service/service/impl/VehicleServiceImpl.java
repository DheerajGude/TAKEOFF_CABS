package com.fleetservice.service.impl;

import com.fleetservice.dto.VehicleRequest;
import com.fleetservice.dto.VehicleResponse;
import com.fleetservice.entity.Vehicle;
import com.fleetservice.exception.ResourceNotFoundException;
import com.fleetservice.repository.VehicleRepository;
import com.fleetservice.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    private VehicleResponse mapToResponse(Vehicle vehicle) {
        return VehicleResponse.builder()
                .id(vehicle.getId())
                .registrationNumber(vehicle.getRegistrationNumber())
                .model(vehicle.getModel())
                .type(vehicle.getType())
                .available(vehicle.isAvailable())
                .status(vehicle.getStatus())
                .build();
    }

    @Override
    public VehicleResponse addVehicle(VehicleRequest request) {
        Vehicle vehicle = Vehicle.builder()
                .registrationNumber(request.getRegistrationNumber())
                .model(request.getModel())
                .type(request.getType())
                .available(true)
                .status("ACTIVE")
                .build();

        return mapToResponse(vehicleRepository.save(vehicle));
    }

    @Override
    public List<VehicleResponse> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleResponse getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
        return mapToResponse(vehicle);
    }

    @Override
    public VehicleResponse updateVehicle(Long id, VehicleRequest request) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        vehicle.setModel(request.getModel());
        vehicle.setType(request.getType());
        vehicle.setRegistrationNumber(request.getRegistrationNumber());

        return mapToResponse(vehicleRepository.save(vehicle));
    }

    @Override
    public void deleteVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
        vehicleRepository.delete(vehicle);
    }

    @Override
    public VehicleResponse changeAvailability(Long id, boolean available) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        vehicle.setAvailable(available);
        return mapToResponse(vehicleRepository.save(vehicle));
    }

    @Override
    public VehicleResponse updateStatus(Long id, String status) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        vehicle.setStatus(status);
        return mapToResponse(vehicleRepository.save(vehicle));
    }
}

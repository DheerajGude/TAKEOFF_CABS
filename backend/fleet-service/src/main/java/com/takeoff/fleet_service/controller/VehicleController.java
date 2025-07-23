package com.fleetservice.controller;

import com.fleetservice.dto.VehicleRequest;
import com.fleetservice.dto.VehicleResponse;
import com.fleetservice.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fleet")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<VehicleResponse> addVehicle(@RequestBody VehicleRequest request) {
        return ResponseEntity.ok(vehicleService.addVehicle(request));
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponse>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponse> getVehicleById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleResponse> updateVehicle(@PathVariable Long id, @RequestBody VehicleRequest request) {
        return ResponseEntity.ok(vehicleService.updateVehicle(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/availability")
    public ResponseEntity<VehicleResponse> changeAvailability(@PathVariable Long id, @RequestParam boolean available) {
        return ResponseEntity.ok(vehicleService.changeAvailability(id, available));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<VehicleResponse> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(vehicleService.updateStatus(id, status));
    }
}

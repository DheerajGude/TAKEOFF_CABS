package com.fleetservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleRequest {
    private String registrationNumber;
    private String model;
    private String type;
}

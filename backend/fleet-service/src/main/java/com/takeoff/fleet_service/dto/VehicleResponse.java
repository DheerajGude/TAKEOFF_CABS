package com.fleetservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleResponse {
    private Long id;
    private String registrationNumber;
    private String model;
    private String type;
    private boolean available;
    private String status;
}

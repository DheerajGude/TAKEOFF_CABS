package com.fleetservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String registrationNumber;

    private String model;

    private String type; // Sedan, SUV, Hatchback, etc.

    private boolean available;

    private String status; // ACTIVE, UNDER_MAINTENANCE, OUT_OF_SERVICE
}

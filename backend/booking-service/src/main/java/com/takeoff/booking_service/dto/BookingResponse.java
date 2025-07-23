package com.bookingservice.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingResponse {
    private UUID id;
    private UUID userId;
    private UUID fleetId;
    private String pickupLocation;
    private String dropLocation;
    private LocalDateTime pickupTime;
    private LocalDateTime dropTime;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

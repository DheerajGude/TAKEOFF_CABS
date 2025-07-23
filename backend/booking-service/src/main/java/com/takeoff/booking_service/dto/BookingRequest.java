package com.bookingservice.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingRequest {
    private UUID userId;
    private UUID fleetId;
    private String pickupLocation;
    private String dropLocation;
    private LocalDateTime pickupTime;
    private LocalDateTime dropTime;
}

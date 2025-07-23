package com.bookingservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingStatusUpdateRequest {
    private String status; // BOOKED, CANCELLED, COMPLETED
}

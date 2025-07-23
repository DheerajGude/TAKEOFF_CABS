package com.bookingservice.controller;

import com.bookingservice.dto.BookingRequestDto;
import com.bookingservice.dto.BookingResponseDto;
import com.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Create a new booking
    @PostMapping
    public ResponseEntity<BookingResponseDto> createBooking(@RequestBody BookingRequestDto bookingRequest) {
        BookingResponseDto created = bookingService.createBooking(bookingRequest);
        return ResponseEntity.ok(created);
    }

    // Get booking by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookingResponseDto> getBookingById(@PathVariable UUID id) {
        BookingResponseDto response = bookingService.getBookingById(id);
        return ResponseEntity.ok(response);
    }

    // Get all bookings
    @GetMapping
    public ResponseEntity<List<BookingResponseDto>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    // Get all bookings by userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookingResponseDto>> getBookingsByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(bookingService.getBookingsByUserId(userId));
    }

    // Cancel a booking
    @PutMapping("/{id}/cancel")
    public ResponseEntity<Void> cancelBooking(@PathVariable UUID id) {
        bookingService.cancelBooking(id);
        return ResponseEntity.noContent().build();
    }
}

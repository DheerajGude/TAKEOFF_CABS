package com.bookingservice.service;

import com.bookingservice.dto.BookingRequestDto;
import com.bookingservice.dto.BookingResponseDto;

import java.util.List;
import java.util.UUID;

public interface BookingService {

    BookingResponseDto createBooking(BookingRequestDto bookingRequest);

    BookingResponseDto getBookingById(UUID bookingId);

    List<BookingResponseDto> getAllBookings();

    List<BookingResponseDto> getBookingsByUserId(UUID userId);

    void cancelBooking(UUID bookingId);
}

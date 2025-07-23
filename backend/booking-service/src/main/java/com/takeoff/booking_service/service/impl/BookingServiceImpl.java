package com.bookingservice.service.impl;

import com.bookingservice.dto.BookingRequestDto;
import com.bookingservice.dto.BookingResponseDto;
import com.bookingservice.entity.Booking;
import com.bookingservice.exception.BookingNotFoundException;
import com.bookingservice.repository.BookingRepository;
import com.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public BookingResponseDto createBooking(BookingRequestDto bookingRequest) {
        Booking booking = new Booking();
        booking.setUserId(bookingRequest.getUserId());
        booking.setFleetId(bookingRequest.getFleetId());
        booking.setBookingDate(bookingRequest.getBookingDate());
        booking.setStatus("BOOKED");

        Booking saved = bookingRepository.save(booking);
        return mapToDto(saved);
    }

    @Override
    public BookingResponseDto getBookingById(UUID bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + bookingId));
        return mapToDto(booking);
    }

    @Override
    public List<BookingResponseDto> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingResponseDto> getBookingsByUserId(UUID userId) {
        return bookingRepository.findByUserId(userId).stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void cancelBooking(UUID bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + bookingId));
        booking.setStatus("CANCELLED");
        bookingRepository.save(booking);
    }

    private BookingResponseDto mapToDto(Booking booking) {
        BookingResponseDto dto = new BookingResponseDto();
        dto.setId(booking.getId());
        dto.setUserId(booking.getUserId());
        dto.setFleetId(booking.getFleetId());
        dto.setBookingDate(booking.getBookingDate());
        dto.setStatus(booking.getStatus());
        return dto;
    }
}

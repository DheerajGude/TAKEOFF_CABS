package com.bookingservice.repository;

import com.bookingservice.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookingRepository extends JpaRepository<Booking, UUID> {

    List<Booking> findByUserId(UUID userId);

    List<Booking> findByFleetId(UUID fleetId);

    List<Booking> findByStatus(String status);
}

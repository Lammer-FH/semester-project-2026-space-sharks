package com.company.repository;

import com.company.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    boolean existsByRoomIdAndStartDateLessThanAndEndDateGreaterThan(
            Integer roomId,
            LocalDate endDate,
            LocalDate startDate
    );
}
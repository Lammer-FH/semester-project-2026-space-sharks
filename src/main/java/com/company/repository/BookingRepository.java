package com.company.repository;

import com.company.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

boolean existsByRoomIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            Integer roomId,
            LocalDate endDate,
            LocalDate startDate
    );

    List<Booking> findByGuestId(Integer guestId);
}
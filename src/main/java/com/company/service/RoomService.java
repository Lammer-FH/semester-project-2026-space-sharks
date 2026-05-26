package com.company.service;

import com.company.entity.Room;
import com.company.repository.RoomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.company.dto.AvailabilityResponse;
import com.company.repository.BookingRepository;
import java.time.LocalDate;

@Service
public class RoomService {

    private final BookingRepository bookingRepository;

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository, BookingRepository bookingRepository) {
    this.roomRepository = roomRepository;
    this.bookingRepository = bookingRepository;
}

    public Page<Room> getRooms(Integer hotelId, int page, int size) {
        return roomRepository.findByHotelId(hotelId, PageRequest.of(page, size));
    }

    public Room getRoomById(Integer id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
    }

    public AvailabilityResponse checkAvailability(Integer roomId, LocalDate startDate, LocalDate endDate) {
        getRoomById(roomId);
    
        boolean hasOverlap = bookingRepository.existsByRoomIdAndStartDateLessThanAndEndDateGreaterThan(
                roomId,
                endDate,
                startDate
        );
    
        return new AvailabilityResponse(roomId, startDate, endDate, !hasOverlap);
    }
}
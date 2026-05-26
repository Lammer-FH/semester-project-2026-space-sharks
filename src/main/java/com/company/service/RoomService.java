package com.company.service;

import com.company.entity.Room;
import com.company.repository.RoomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.company.dto.AvailabilityResponse;
import com.company.exception.BadRequestException;
import com.company.exception.ResourceNotFoundException;
import com.company.repository.BookingRepository;
import java.time.LocalDate;

@Service
public class RoomService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final HotelService hotelService;

    public RoomService(
            RoomRepository roomRepository,
            BookingRepository bookingRepository,
            HotelService hotelService
    ) {
        this.roomRepository = roomRepository;
        this.bookingRepository = bookingRepository;
        this.hotelService = hotelService;
    }

    public Page<Room> getRooms(Integer hotelId, int page, int size) {
        hotelService.getHotelById(hotelId);
        return roomRepository.findByHotel_Id(hotelId, PageRequest.of(page, size));
    }

    public Room getRoomById(Integer roomId, Integer hotelId) {
        hotelService.getHotelById(hotelId);
        return roomRepository.findByIdAndHotel_Id(roomId, hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel or room not found"));
    }

    public AvailabilityResponse checkAvailability(
            Integer roomId,
            Integer hotelId,
            LocalDate startDate,
            LocalDate endDate
    ) {
        validateDateRange(startDate, endDate);
        getRoomById(roomId, hotelId);

        boolean hasOverlap = bookingRepository.existsByRoomIdAndStartDateLessThanAndEndDateGreaterThan(
                roomId,
                endDate,
                startDate
        );
    
        return new AvailabilityResponse(roomId, startDate, endDate, !hasOverlap);
    }

    private void validateDateRange(LocalDate startDate, LocalDate endDate) {
        if (startDate.isBefore(LocalDate.now())) {
            throw new BadRequestException("startDate must not be in the past");
        }
        if (!endDate.isAfter(startDate)) {
            throw new BadRequestException("endDate must be after startDate");
        }
    }
}
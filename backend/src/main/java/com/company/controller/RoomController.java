package com.company.controller;

import com.company.dto.AvailabilityResponse;
import com.company.dto.PageResponse;
import com.company.dto.RoomResponse;
import com.company.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public PageResponse<RoomResponse> getAllRooms(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            @RequestParam(name = "hotel_id") int hotelId
    ) {
        return roomService.getRooms(hotelId, page, size);
    }

    @GetMapping("/{roomId}")
    public RoomResponse getRoomById(
            @PathVariable Integer roomId,
            @RequestParam(name = "hotel_id") int hotelId
    ) {
        return roomService.getRoomById(roomId);
    }

    @GetMapping("/{roomId}/availability")
    public AvailabilityResponse getRoomAvailability(
            @PathVariable Integer roomId,
            @RequestParam(name = "startDate") LocalDate startDate,
            @RequestParam(name = "endDate") LocalDate endDate
    ) {
        return roomService.getRoomAvailability(roomId, startDate, endDate);
    }
}

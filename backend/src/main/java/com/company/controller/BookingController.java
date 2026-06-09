package com.company.controller;

import com.company.model.RequestBooking;
import com.company.service.BookingService;
import com.company.dto.BookingResponse;
import com.company.mapper.ResponseMapper;
import com.company.entity.Booking;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingResponse> createBooking(
            @RequestBody RequestBooking requestBooking,
            @RequestParam(name = "user_id") Integer userId
    ) {
        return this.bookingService.createBooking(
            userId,
            requestBooking.getRoomId(),
            requestBooking.getFirstName(),
            requestBooking.getLastName(),
            requestBooking.getEmail(),
            requestBooking.getStartDate(),
            requestBooking.getEndDate(),
            requestBooking.getBreakfast()
        );
    }

    @GetMapping
    public List<BookingResponse> getBookingsOfUser(@RequestParam(name = "user_id") int userId) {
        return bookingService.getBookingsByGuestId(userId);
    }

    @GetMapping("/{id}")
    public BookingResponse getBookingOfUserById(
            @PathVariable Integer id,
            @RequestParam(name = "user_id") int userId
    ) {

        Booking booking = bookingService.getBookingOfGuestById(id, userId);

        return ResponseMapper.toBookingResponse(booking);
    }
}

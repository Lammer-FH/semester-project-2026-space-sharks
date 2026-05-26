package com.company.controller;

import com.company.model.RequestBooking;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @PostMapping
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public void createBooking(
            @RequestBody RequestBooking requestBooking,
            @RequestParam(name = "user_id") int userId
    ) {
    }

    @GetMapping
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public void getBookingsOfUser(@RequestParam(name = "user_id") int userId) {
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public void getBookingById(
            @PathVariable Long id,
            @RequestParam(name = "user_id") int userId
    ) {
    }
}

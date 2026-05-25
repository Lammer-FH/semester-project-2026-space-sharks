package com.company.controller;

import com.company.model.RequestBooking;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @PostMapping
    public String createBooking(@RequestBody RequestBooking requestBooking,
                                @RequestParam(name = "user_id") int userId)
    {
        System.out.println(requestBooking);
        System.out.println(userId);
        return "Create Booking is not Implemented";
    }

    @GetMapping
    public String getBookingOfUser(@RequestParam(name = "user_id") int userId) {
        return "Get all Bookings of user is not implemented";
    }

    @GetMapping("/{id}")
    public String getRoomById(@PathVariable Long id,
                              @RequestParam(name = "user_id") int userId)
    {

        System.out.println(id);
        System.out.println(userId);

        return "Get Guest by ID is not implemented";
    }
}

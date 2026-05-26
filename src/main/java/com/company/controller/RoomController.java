package com.company.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @GetMapping
    public String getAllRooms(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                              @RequestParam(name = "size", required = false, defaultValue = "5") int size,
                              @RequestParam(name = "hotel_id") int hotelId)
    {
        System.out.println(page);
        System.out.println(size);
        System.out.println(hotelId);

        return "Get Rooms is not Implemented";
    }

    @GetMapping("/{roomId}")
    public String getRoomById(@PathVariable Long roomId,
                              @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                              @RequestParam(name = "size", required = false, defaultValue = "5") int size,
                              @RequestParam(name = "hotel_id") int hotelId)
    {

        System.out.println(page);
        System.out.println(size);
        System.out.println(hotelId);
        System.out.println(roomId);

        return "Get Guest by ID is not implemented";
    }

    @GetMapping("/{roomId}/availability")
    public String getRoomAvailability(@PathVariable Long roomId,
                                      @RequestParam(name = "startDate") Date startDate,
                                      @RequestParam(name = "endDate") Date endDate,
                                      @RequestParam(name = "hotel_id") int hotelId)
    {


        System.out.println(startDate);
        System.out.println(endDate);
        System.out.println(hotelId);
        System.out.println(roomId);

        return "Get Guest by ID is not implemented";
    }
}

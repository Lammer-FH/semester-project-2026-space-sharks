package com.company.controller;

import com.company.dto.HotelResponse;
import com.company.dto.PageResponse;
import com.company.service.HotelService;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public PageResponse<HotelResponse> getHotels(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size
    ) {
        return hotelService.getHotels(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public HotelResponse getHotelById(@PathVariable Integer id) {
        return hotelService.getHotelById(id);
    }
}

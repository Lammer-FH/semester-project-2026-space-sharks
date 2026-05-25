package com.company.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @GetMapping
    public String getHotels(@RequestParam(name = "page", required = false, defaultValue = "0") int page, @RequestParam(name = "size", required = false, defaultValue = "5") int size) {
        System.out.println(page);
        System.out.println(size);
        return "Get Hotels is not Implemented";
    }

    @GetMapping("/{id}")
    public String getHotelById(@PathVariable Long id) {
        return "Get Hotel by ID is not implemented";
    }
}

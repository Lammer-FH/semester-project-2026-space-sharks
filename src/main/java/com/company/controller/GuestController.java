package com.company.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @PostMapping
    public String createGuest() {
        return "Create Guest is not Implemented";
    }

    @GetMapping("/{id}")
    public String getGuest(@PathVariable Long id) {
        return "Get Guest by ID is not implemented";
    }

    @PutMapping("/{id}")
    public String updateGuest(@PathVariable Long id) {
        return "Update Guest by ID is not implemented";
    }

    @DeleteMapping("/{id}")
    public String deleteGuest(@PathVariable Long id) {
        return "Delete Guest by ID is not implemented";
    }
}

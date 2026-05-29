package com.company.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @PostMapping
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public void createGuest() {
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public void getGuest(@PathVariable Long id) {
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public void updateGuest(@PathVariable Long id) {
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public void deleteGuest(@PathVariable Long id) {
    }
}

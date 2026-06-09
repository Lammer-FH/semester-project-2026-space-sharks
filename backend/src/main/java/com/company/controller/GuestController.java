package com.company.controller;

import com.company.repository.GuestRepository;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.company.dto.GuestResponse;
import com.company.entity.Guest;
import com.company.model.RequestGuest;
import com.company.service.GuestService;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private final GuestService guestService;
    private final GuestRepository guestRepository;

    public GuestController(GuestService guestService, GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
        this.guestService = guestService;
    }

    @PostMapping
    public ResponseEntity<GuestResponse> createGuest(@RequestBody RequestGuest requestGuest) {

        return this.guestService.createGuest(
            requestGuest.getFirstName(),
            requestGuest.getLastName(),
            requestGuest.getEmail()
        );
    }

    @GetMapping
    public List<GuestResponse> getAllGuests() {
        return this.guestService.getGuests();
    }

    @GetMapping("/{id}")
    public GuestResponse getGuest(@PathVariable Integer id) {
        return this.guestService.getGuestById(id);
    }

    @PutMapping("/{id}")
    public void updateGuest(@PathVariable Integer id, @RequestBody RequestGuest requestGuest) {
        Guest guest = this.guestService.findGuestById(id);

        guest.setFirstName(requestGuest.getFirstName());
        guest.setLastName(requestGuest.getLastName());
        guest.setEmail(requestGuest.getEmail());

        this.guestRepository.save(guest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Integer id) {
        this.guestService.deleteGuest(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .body(null);
    }
}

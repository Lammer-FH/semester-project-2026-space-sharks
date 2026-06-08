package com.company.service;

import com.company.dto.GuestResponse;
import com.company.entity.Guest;
import com.company.exception.ResourceNotFoundException;
import com.company.mapper.ResponseMapper;
import com.company.repository.GuestRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GuestService {

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public ResponseEntity<GuestResponse> createGuest(String firstName, String lastName, String email) {
        Guest guest = new Guest();
        guest.setFirstName(firstName);
        guest.setLastName(lastName);
        guest.setEmail(email);

        checkIfEmailDuplicate(email);
        // @TODO email string validation?
        // @TODO date range validation.

        Guest createdGuest = guestRepository.save(guest);

        GuestResponse response = ResponseMapper.toGuestResponse(createdGuest);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(response);

    }

    public List<GuestResponse> getGuests() {
        List<Guest> guests = guestRepository.findAll();
        return ResponseMapper.toGuestResponses(guests);
    }

    public GuestResponse getGuestById(Integer id) {
        return ResponseMapper.toGuestResponse(findGuestById(id));
    }

    public void deleteGuest(Integer id) {
        Guest guest = findGuestById(id);

        guestRepository.delete(guest);
    }

    public Guest findGuestById(Integer id) {
        return guestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Guest not found"));
    }

    public Guest createAndReturnGuest(String firstName, String lastName, String email) {
        Guest guest = new Guest();
        guest.setFirstName(firstName);
        guest.setLastName(lastName);
        guest.setEmail(email);
        return guestRepository.save(guest);
    }

    public Optional<Guest> findExistingGuest(String firstName, String lastName, String email) {
        return guestRepository.findByFirstNameAndLastNameAndEmail(
            firstName,
            lastName,
            email
        );
    }

    private void checkIfEmailDuplicate(String email) {
        if (guestRepository.existsByEmail(email)) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Guest with this email already exists"
            );
        }
    }

}

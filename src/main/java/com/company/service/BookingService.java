package com.company.service;

import com.company.dto.BookingResponse;
import com.company.entity.Booking;
import com.company.entity.Guest;
import com.company.entity.Room;
import com.company.exception.ResourceNotFoundException;
import com.company.mapper.ResponseMapper;
import com.company.repository.BookingRepository;
import com.company.repository.RoomRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingService {

    private final RoomRepository roomRepository;

    private final BookingRepository bookingRepository;

    private final GuestService guestService;

    public BookingService(RoomRepository roomRepository, BookingRepository bookingRepository, GuestService guestService) {
        this.roomRepository = roomRepository;
        this.bookingRepository = bookingRepository;
        this.guestService = guestService;
    }

    public ResponseEntity<BookingResponse> createBooking(Integer userId, Integer roomId, String firstName, String lastName, String email, LocalDate startDate, LocalDate endDate, Boolean breakfast) {

        Room room = roomRepository.findById(roomId)
            .orElseThrow(() -> new ResourceNotFoundException("Room not found"));


        boolean isRoomOccupied = bookingRepository.existsByRoomIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                roomId,
                endDate,
                startDate
        );

        if (isRoomOccupied) {
            // 409 error if room not available.
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(null);
        }

        Guest guest = guestService.findExistingGuest(firstName, lastName, email)
                .orElseGet(() -> guestService.createAndReturnGuest(firstName, lastName, email));

        Booking booking = new Booking();
        booking.setGuest(guest);
        
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setRoom(room);
        booking.setBreakfast(breakfast);

        booking.setCreatedAt(LocalDateTime.now());

        // booking.setConfirmed(false);
        booking.setConfirmed(true);

        Booking createdBooking = bookingRepository.save(booking);

        BookingResponse response = ResponseMapper.toBookingResponse(createdBooking);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(response);
    }

    public List<BookingResponse> getBookingsByGuestId(Integer guestId) {
        List<Booking> bookings = findBookingsByGuestId(guestId);
        
        return ResponseMapper.toBookingResponses(bookings);
    }

    public BookingResponse getBookingById(Integer id) {
        return ResponseMapper.toBookingResponse(findBookingById(id));
    }

    public Booking getBookingOfGuestById(Integer bookingId, Integer guestId) {
        Booking booking = findBookingById(bookingId);

        if (booking.getGuest().getId() != guestId) {
            // 403 error.
            throw new ResourceAccessException("You have no rights to see this page");
        }
        
        return booking;
    }

    private Booking findBookingById(Integer id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
    }

    private List<Booking> findBookingsByGuestId(Integer guestId) {
        List<Booking> bookingsByGuest = bookingRepository.findByGuestId(guestId);

        if (bookingsByGuest.isEmpty()) {
            throw new ResourceNotFoundException("No bookings found");
        }

        return bookingsByGuest;
                
    }
}

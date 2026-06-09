package com.company.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record BookingResponse (
    Integer id,
    RoomResponse room,
    GuestResponse guest,
    LocalDate startDate,
    LocalDate endDate,
    Boolean breakfast,
    Boolean confirmed,
    LocalDateTime createdAt
) {
}

package com.company.dto;

import java.time.LocalDate;

public record AvailabilityResponse(
        Integer roomId,
        LocalDate startDate,
        LocalDate endDate,
        boolean available
) {
}
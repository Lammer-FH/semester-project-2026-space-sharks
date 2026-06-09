package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.Builder;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@ToString
@Builder
public class RequestBooking {
    private Integer roomId;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean breakfast;
}

package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.Builder;

import java.util.Date;

@AllArgsConstructor
@Getter
@ToString
@Builder
public class RequestBooking {
    private String firstName;
    private String lastName;
    private String email;
    private Date startDate;
    private Date endDate;
    private boolean breakfast;
}
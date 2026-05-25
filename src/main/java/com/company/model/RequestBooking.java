package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@Getter
@ToString
@Builder
public record RequestBooking(String firstName, String lastName, String email, Date startDate, Date endDate, boolean breakfast) {

}

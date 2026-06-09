package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.Builder;

@AllArgsConstructor
@Getter
@ToString
@Builder
public class RequestGuest {
    private String firstName;
    private String lastName;
    private String email;
}
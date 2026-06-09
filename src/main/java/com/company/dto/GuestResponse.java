package com.company.dto;

public record GuestResponse (
    Integer id,
    String firstName,
    String lastName,
    String email
) {
}

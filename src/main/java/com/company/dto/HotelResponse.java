package com.company.dto;

public record HotelResponse(
        Integer id,
        String name,
        String description,
        String location,
        String imageUrl
) {
}

package com.company.dto;

import java.util.List;

public record RoomResponse(
        Integer id,
        Integer hotelId,
        String name,
        String description,
        Integer pricePerNight,
        Integer maxOccupants,
        String imageUrl,
        List<FeatureResponse> features
) {
}

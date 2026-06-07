package com.company.mapper;

import com.company.dto.FeatureResponse;
import com.company.dto.HotelResponse;
import com.company.dto.PageResponse;
import com.company.dto.RoomResponse;
import com.company.dto.GuestResponse;
import com.company.entity.Feature;
import com.company.entity.Hotel;
import com.company.entity.Room;
import com.company.entity.Guest;
import org.springframework.data.domain.Page;

import java.util.Collections;
import java.util.List;

public final class ResponseMapper {

    private ResponseMapper() {
    }

    public static HotelResponse toHotelResponse(Hotel hotel) {
        return new HotelResponse(
                hotel.getId(),
                hotel.getName(),
                hotel.getDescription(),
                hotel.getLocation(),
                hotel.getImageUrl()
        );
    }

    public static RoomResponse toRoomResponse(Room room) {
        return new RoomResponse(
                room.getId(),
                room.getHotel() != null ? room.getHotel().getId() : null,
                room.getName(),
                room.getDescription(),
                room.getPricePerNight(),
                room.getMaxOccupants(),
                room.getImageUrl(),
                toFeatureResponses(room.getFeatures())
        );
    }

    public static FeatureResponse toFeatureResponse(Feature feature) {
        return new FeatureResponse(feature.getId(), feature.getName(), feature.getIcon());
    }

    public static GuestResponse toGuestResponse(Guest guest) {
        return new GuestResponse(
            guest.getId(),
            guest.getFirstName(),
            guest.getLastName(),
            guest.getEmail()
        );
    }

    public static PageResponse<HotelResponse> toHotelPage(Page<Hotel> page) {
        List<HotelResponse> content = page.getContent().stream()
                .map(ResponseMapper::toHotelResponse)
                .toList();
        return PageResponse.from(page, content);
    }

    public static PageResponse<RoomResponse> toRoomPage(Page<Room> page) {
        List<RoomResponse> content = page.getContent().stream()
                .map(ResponseMapper::toRoomResponse)
                .toList();
        return PageResponse.from(page, content);
    }

    public static List<GuestResponse> toGuestResponses(List<Guest> guests) {
        if (guests == null) {
            return Collections.emptyList();
        }
        return guests.stream().map(ResponseMapper::toGuestResponse).toList();
    }

    private static List<FeatureResponse> toFeatureResponses(List<Feature> features) {
        if (features == null) {
            return Collections.emptyList();
        }
        return features.stream().map(ResponseMapper::toFeatureResponse).toList();
    }
}

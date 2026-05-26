package com.company.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "room")
@Getter
@Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
@JoinColumn(name = "hotel_id")
@JsonBackReference
private Hotel hotel;

    private String name;

    private String description;

    @Column(name = "price_per_night")
    private Integer pricePerNight;

    @Column(name = "max_occupants")
    private Integer maxOccupants;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToMany
@JoinTable(
        name = "room_feature",
        joinColumns = @JoinColumn(name = "room_id"),
        inverseJoinColumns = @JoinColumn(name = "feature_id")
)
private List<Feature> features;

    @JsonProperty("hotelId")
    public Integer getHotelId() {
        return hotel != null ? hotel.getId() : null;
    }
}
package com.company.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
@Table(name = "hotel")
@Getter
@Setter
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private String location;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "hotel")
    @JsonManagedReference
    private List<Room> rooms;
}
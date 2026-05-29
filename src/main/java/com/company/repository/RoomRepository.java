package com.company.repository;

import com.company.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Page<Room> findByHotel_Id(Integer hotelId, Pageable pageable);

    Optional<Room> findByIdAndHotel_Id(Integer id, Integer hotelId);
}
package com.company.repository;

import com.company.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface RoomRepository extends JpaRepository<Room, Integer> {
    Page<Room> findByHotel_Id(Integer hotelId, Pageable pageable);

}
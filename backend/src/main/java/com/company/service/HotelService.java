package com.company.service;

import com.company.dto.HotelResponse;
import com.company.dto.PageResponse;
import com.company.entity.Hotel;
import com.company.exception.ResourceNotFoundException;
import com.company.mapper.ResponseMapper;
import com.company.repository.HotelRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public PageResponse<HotelResponse> getHotels(Pageable pageable) {
        Page<Hotel> page = hotelRepository.findAll(pageable);
        return ResponseMapper.toHotelPage(page);
    }

    public HotelResponse getHotelById(Integer id) {
        return ResponseMapper.toHotelResponse(findHotelById(id));
    }

    public Hotel findHotelById(Integer id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found"));
    }
}

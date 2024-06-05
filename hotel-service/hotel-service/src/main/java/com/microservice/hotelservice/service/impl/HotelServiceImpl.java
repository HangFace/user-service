package com.microservice.hotelservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.hotelservice.entity.Hotel;
import com.microservice.hotelservice.exception.ResourceNotFoundException;
import com.microservice.hotelservice.repository.HotelRepository;
import com.microservice.hotelservice.service.HotelService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

  private final HotelRepository hotelRepository;

  @Override
  public Hotel saveHotel(Hotel hotel) {
    log.info("Hotel with name {} is saved", hotel.getName());
    return hotelRepository.save(hotel);
  }

  @Override
  public List<Hotel> getAllHotels() {
    log.info("Get all hotels list");
    return hotelRepository.findAll();
  }

  @Override
  public Hotel getHotel(String id) {
    log.info("Fetched hotel with id {}", id);
    return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel not found..!!"));
  }
}

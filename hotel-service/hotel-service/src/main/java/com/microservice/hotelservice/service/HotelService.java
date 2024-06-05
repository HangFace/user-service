package com.microservice.hotelservice.service;

import java.util.List;

import com.microservice.hotelservice.entity.Hotel;

public interface HotelService {

  Hotel saveHotel(Hotel hotel);

  List<Hotel> getAllHotels();

  Hotel getHotel(String id);
}

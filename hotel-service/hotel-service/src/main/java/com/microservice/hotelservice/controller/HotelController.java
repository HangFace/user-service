package com.microservice.hotelservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.hotelservice.entity.Hotel;
import com.microservice.hotelservice.service.HotelService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/hotel")
@AllArgsConstructor
public class HotelController {

  private final HotelService hotelService;

  @PostMapping
  public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
    Hotel saveHotel = hotelService.saveHotel(hotel);
    return new ResponseEntity<>(saveHotel, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Hotel>> getAlleHotels() {
    List<Hotel> allHotels = hotelService.getAllHotels();
    return new ResponseEntity<>(allHotels, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Hotel> geteHotel(@PathVariable String id) {
    Hotel hotel = hotelService.getHotel(id);
    return new ResponseEntity<>(hotel, HttpStatus.OK);
  }
}

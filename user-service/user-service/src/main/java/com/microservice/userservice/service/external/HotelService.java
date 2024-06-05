package com.microservice.userservice.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.userservice.entity.Hotel;

@FeignClient("HOTEL-SERVICE")
public interface HotelService {

  @GetMapping("/hotel/{hotelId}")
  Hotel getHotel(@PathVariable("hotelId") String hotelId);
}

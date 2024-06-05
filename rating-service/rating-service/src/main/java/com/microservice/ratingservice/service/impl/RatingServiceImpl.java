package com.microservice.ratingservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.ratingservice.entity.Rating;
import com.microservice.ratingservice.repository.RatingRepository;
import com.microservice.ratingservice.service.RatingService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class RatingServiceImpl implements RatingService {

  private final RatingRepository ratingRepository;

  @Override
  public Rating saveRating(Rating rating) {
    return ratingRepository.save(rating);
  }

  @Override
  public List<Rating> getAllRatings() {
    return ratingRepository.findAll();
  }

  @Override
  public List<Rating> getAllRatingsByUser(String userId) {
    return ratingRepository.findByUserId(userId);
  }

  @Override
  public List<Rating> getAllRatingsByHotel(String hotelId) {
    return ratingRepository.findByHotelId(hotelId);
  }

  @Override
  public Rating getRating(String id) {
    return ratingRepository.findById(id).orElseThrow();
  }
}

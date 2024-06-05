package com.microservice.ratingservice.service;

import java.util.List;

import com.microservice.ratingservice.entity.Rating;

public interface RatingService {

  Rating saveRating(Rating rating);

  List<Rating> getAllRatings();

  List<Rating> getAllRatingsByUser(String userId);

  List<Rating> getAllRatingsByHotel(String hotelId);

  Rating getRating(String id);


}

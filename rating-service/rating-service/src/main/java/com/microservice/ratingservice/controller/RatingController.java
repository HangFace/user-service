package com.microservice.ratingservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.ratingservice.entity.Rating;
import com.microservice.ratingservice.service.RatingService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/rating")
@AllArgsConstructor
public class RatingController {

  private final RatingService ratingService;

  @PostMapping
  public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
    Rating saveRating = ratingService.saveRating(rating);
    return new ResponseEntity<>(saveRating, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Rating>> getAllRatings() {
    List<Rating> allRatings = ratingService.getAllRatings();
    return new ResponseEntity<>(allRatings, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Rating> getRating(@PathVariable String id) {
    Rating rating = ratingService.getRating(id);
    return new ResponseEntity<>(rating, HttpStatus.OK);
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable String id) {
    List<Rating> allRatingsByUser = ratingService.getAllRatingsByUser(id);
    return new ResponseEntity<>(allRatingsByUser, HttpStatus.OK);
  }

  @GetMapping("/hotel/{id}")
  public ResponseEntity<List<Rating>> getAllRatingByHotelId(@PathVariable String id) {
    List<Rating> allRatingsByHotel = ratingService.getAllRatingsByHotel(id);
    return new ResponseEntity<>(allRatingsByHotel, HttpStatus.OK);
  }
}

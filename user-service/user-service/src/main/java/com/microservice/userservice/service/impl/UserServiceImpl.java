package com.microservice.userservice.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.userservice.entity.Hotel;
import com.microservice.userservice.entity.Rating;
import com.microservice.userservice.entity.User;
import com.microservice.userservice.exception.ResourseNotFoundException;
import com.microservice.userservice.repository.UserRepository;
import com.microservice.userservice.service.UserService;
import com.microservice.userservice.service.external.HotelService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  private RestTemplate restTemplate;

  private HotelService hotelService;

  @Override
  public User saveUser(User user) {
    log.info("User with name {} is created", user.getName());
    return userRepository.save(user);
  }

  @Override
  public List<User> getAllUsers() {
    log.info("Get all the users");
    return userRepository.findAll();
  }

  @Override
  public User getUser(String id) {
    userRepository.findById(id);
    log.info("User with id {} is fetched", id);

    User user = userRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("User not found..!!"));

    Rating[] ratingsOfUsers = restTemplate.getForObject("http://RATING-SERVICE/rating/user/" + user.getId(),
        Rating[].class);

    log.info("Rating service: " + Arrays.toString(ratingsOfUsers));

    assert ratingsOfUsers != null;

    List<Rating> ratings = Arrays.stream(ratingsOfUsers).toList();

    List<Rating> collect = ratings.stream().map(rating -> {
      Hotel hotel = hotelService.getHotel(rating.getHotelId());
      rating.setHotel(hotel);
      return rating;
    }).collect(Collectors.toList());

    user.setRatings(collect);

    return user;
  }
}

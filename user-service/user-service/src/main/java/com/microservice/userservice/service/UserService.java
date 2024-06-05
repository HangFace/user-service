package com.microservice.userservice.service;

import java.util.List;

import com.microservice.userservice.entity.User;

public interface UserService {

  User saveUser(User user);

  List<User> getAllUsers();

  User getUser(String id);
}

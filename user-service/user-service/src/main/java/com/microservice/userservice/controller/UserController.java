package com.microservice.userservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.userservice.entity.User;
import com.microservice.userservice.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping
  public ResponseEntity<User> saveUser(@RequestBody User user) {
    User saveUser = userService.saveUser(user);

    return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<User>> getAllUser() {
    List<User> allUsers = userService.getAllUsers();

    return new ResponseEntity<>(allUsers, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUser(@PathVariable String id) {
    User user = userService.getUser(id);

    return new ResponseEntity<>(user, HttpStatus.OK);
  }
}

package com.microservice.hotelservice.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException exception) {

    String message = exception.getMessage();
    Map<String, Object> map = new HashMap<>();
    map.put("Message", message);
    map.put("Success", false);
    map.put("HttpStatus", HttpStatus.NOT_FOUND);

    return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
  }

}

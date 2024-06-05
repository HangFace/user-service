package com.microservice.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microservice.userservice.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourseNotFoundException.class)
  public ResponseEntity<ApiResponse> handleResourseNotFoundException(ResourseNotFoundException exception) {
    String message = exception.getMessage();
    ApiResponse apiResponse = ApiResponse.builder().message(message).success(true).httpStatus(HttpStatus.NOT_FOUND)
        .build();

    return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
  }
}

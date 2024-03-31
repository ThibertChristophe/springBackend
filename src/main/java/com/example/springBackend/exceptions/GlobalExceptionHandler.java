package com.example.springBackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

  // Ici on montre 2 syntaxe de hanlde d'exception
  //
  //
  //
  @ExceptionHandler(HomeNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleHomeNotFoundException(HomeNotFoundException ex) {
    ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(UserNotFoundException.class)
  public @ResponseBody ErrorResponse handleUserNotFoundException(UserNotFoundException ex) {
      return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(BookingNotFoundException.class)
  public @ResponseBody ErrorResponse handleBookingNotFoundException(BookingNotFoundException ex) {
      return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
  }
  
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(RuntimeException.class)
  public @ResponseBody ErrorResponse handleRuntimeException(RuntimeException ex) {
    return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
  }

}

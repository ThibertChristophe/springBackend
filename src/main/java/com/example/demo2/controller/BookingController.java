package com.example.demo2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.dto.BookingDTO;
import com.example.demo2.entities.Booking;
import com.example.demo2.services.BookingService;

@RestController
@RequestMapping(path = "booking", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookingController {
  private final BookingService bookingService;

  public BookingController(BookingService bookingService) {
    this.bookingService = bookingService;
  }

  @ResponseStatus(value = HttpStatus.CREATED)
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public void create(@RequestBody Booking booking) {
    this.bookingService.create(booking);
  }

  @PostMapping(path = "/user/home", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Booking> readBy(@RequestBody BookingDTO bookingDTO) {
    Booking booking = this.bookingService.read(bookingDTO.getUser_id(), bookingDTO.getHome_id());
    return ResponseEntity.ok(booking);
  }
}

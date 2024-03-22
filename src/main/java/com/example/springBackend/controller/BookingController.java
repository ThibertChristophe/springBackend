package com.example.springBackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springBackend.dto.BookingDTO;
import com.example.springBackend.entities.Booking;
import com.example.springBackend.services.BookingService;

import java.util.List;

@RestController
@RequestMapping(path = "booking", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookingController {
  private final BookingService bookingService;

  public BookingController(BookingService bookingService) {
    this.bookingService = bookingService;
  }

  @GetMapping
  public ResponseEntity<List<Booking>> readAll(){
    List<Booking> bookings = bookingService.readAll();
    return ResponseEntity.ok(bookings);
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

  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  @DeleteMapping(path = "{id}")
  public void delete(@PathVariable int id) {
    this.bookingService.deleteById(id);
  }
}

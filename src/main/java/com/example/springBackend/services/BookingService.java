package com.example.springBackend.services;

import org.springframework.stereotype.Service;

import com.example.springBackend.entities.Booking;
import com.example.springBackend.entities.Home;
import com.example.springBackend.entities.User;
import com.example.springBackend.exceptions.BookingNotFoundException;
import com.example.springBackend.repositories.BookingRepository;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {
  private final BookingRepository bookingRepository;

  private final UserService userService;
  private final HomeService homeService;

  public BookingService(BookingRepository bookingRepository, UserService userService, HomeService homeService) {
    this.bookingRepository = bookingRepository;
    this.userService = userService;
    this.homeService = homeService;
  }

  public List<Booking> readAll() {
    return bookingRepository.findAll();
  }

  public void create(Booking booking) {
    User user = userService.read(booking.getUser().getId());
    Home home = homeService.read(booking.getHome().getId());
    booking.setUser(user);
    booking.setHome(home);
    //booking.setDate_created(Date.from(new Date().toInstant()));
    this.bookingRepository.save(booking);
  }

  public Booking read(int idUser, int idHome) {
    Booking booking = this.bookingRepository.findByUser_idAndHome_id(idUser, idHome);
    if (booking == null) {
      throw new BookingNotFoundException();
    }
    return booking;
  }

  public void deleteById(int id) {
    this.bookingRepository.deleteById(id);
  }


}

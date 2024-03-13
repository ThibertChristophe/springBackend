package com.example.demo2.services;

import org.springframework.stereotype.Service;

import com.example.demo2.entities.Booking;
import com.example.demo2.entities.Home;
import com.example.demo2.entities.User;
import com.example.demo2.exceptions.BookingNotFoundException;
import com.example.demo2.repositories.BookingRepository;

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

  public void create(Booking booking) {
    User user = userService.read(booking.getUser().getId());
    Home home = homeService.read(booking.getHome().getId());
    booking.setUser(user);
    booking.setHome(home);
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

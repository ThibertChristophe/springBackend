package com.example.demo2.services;

import org.springframework.stereotype.Service;

import com.example.demo2.entities.Booking;
import com.example.demo2.entities.Home;
import com.example.demo2.entities.User;
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
    // On va chercher le user correspondant sinon on le cree.
    User user = userService.readOrCreate(booking.getUser());
    Home home = homeService.read(booking.getHome().getId());
    booking.setUser(user);
    booking.setHome(home);
    this.bookingRepository.save(booking);
  }
}

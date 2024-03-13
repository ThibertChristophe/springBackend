
package com.example.demo2.exceptions;

public class BookingNotFoundException extends RuntimeException {
  public BookingNotFoundException() {
    super("Booking non trouvé");
  }
}

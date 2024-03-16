
package com.example.springBackend.exceptions;

public class BookingNotFoundException extends RuntimeException {
  public BookingNotFoundException() {
    super("Booking non trouvé");
  }
}

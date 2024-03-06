package com.example.demo2.exceptions;

public class HomeNotFoundException extends RuntimeException {
  public HomeNotFoundException(int homeId) {
    super("Home non trouvée");
  }
}

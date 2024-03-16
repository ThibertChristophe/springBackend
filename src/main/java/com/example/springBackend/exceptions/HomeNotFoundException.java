package com.example.springBackend.exceptions;

public class HomeNotFoundException extends RuntimeException {
  public HomeNotFoundException(int homeId) {
    super("Home non trouvée");
  }
}

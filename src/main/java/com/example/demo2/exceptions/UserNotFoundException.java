
package com.example.demo2.exceptions;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException() {
    super("User non trouvé");
  }

  public UserNotFoundException(int userId) {
    super("User non trouvé");
  }
}

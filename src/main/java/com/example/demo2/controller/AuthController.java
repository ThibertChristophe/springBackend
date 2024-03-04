package com.example.demo2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.dto.LoginRequest;
import com.example.demo2.entities.User;
import com.example.demo2.services.UserService;

@RestController
@RequestMapping("auth")
public class AuthController {

  private final UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
    User user = userService.readByLogin(loginRequest.getLogin());
    if (user == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User non trouvé");
    }
    // verif mot de passe
    if (user.getPassword() != loginRequest.getPassword()) {

      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credentials incorrect");
    }
    return ResponseEntity.status(HttpStatus.OK).body("");
  }
}

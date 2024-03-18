package com.example.springBackend.controller;

import com.example.springBackend.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBackend.dto.LoginRequest;
import com.example.springBackend.entities.User;
import com.example.springBackend.services.UserService;

@RestController
@RequestMapping("auth")
public class AuthController {

  private final UserService userService;
  private final BCryptPasswordEncoder passwordEncoder;

  public AuthController(UserService userService, BCryptPasswordEncoder passwordEncoder) {
    this.userService = userService;
      this.passwordEncoder = passwordEncoder;
  }

  @ResponseStatus(value = HttpStatus.OK)
  @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
    User user = userService.readByUsername(loginRequest.getUsername());
    if (user == null) {
      throw new UserNotFoundException();
    }
    // verif mot de passe
    if (!passwordEncoder.matches(loginRequest.getPassword(),user.getPassword())) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credentials incorrect");
    }
    return ResponseEntity.ok().build();
  }
}

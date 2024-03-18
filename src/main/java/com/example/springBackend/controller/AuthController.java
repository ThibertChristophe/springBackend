package com.example.springBackend.controller;

import com.example.springBackend.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
  private final AuthenticationManager authenticationManager;

  public AuthController(UserService userService, AuthenticationManager authenticationManager) {
    this.userService = userService;
    this.authenticationManager = authenticationManager;
  }

  @ResponseStatus(value = HttpStatus.OK)
  @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
//    User user = userService.readByUsername(loginRequest.getUsername());
//    if (user == null) {
//      throw new UserNotFoundException();
//    }
    try{
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
    }catch(BadCredentialsException e){
      // creer une Exception et l ajouter dans notre handler
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }
    // recup le user
    // generer le token
    // renvoyer le token
      return ResponseEntity.ok().build();
  }
}

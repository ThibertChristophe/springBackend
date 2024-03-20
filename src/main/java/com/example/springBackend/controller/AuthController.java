package com.example.springBackend.controller;

import com.example.springBackend.dto.Bearer;
import com.example.springBackend.entities.User;
import com.example.springBackend.services.UserService;
import com.example.springBackend.utils.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBackend.dto.LoginRequest;

@RestController
@RequestMapping("auth")
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final UserService userService;
  private final JwtUtil jwtUtil;

  public AuthController(AuthenticationManager authenticationManager, UserService userService, JwtUtil jwtUtil) {
    this.authenticationManager = authenticationManager;
      this.userService = userService;
      this.jwtUtil = jwtUtil;
  }

  @ResponseStatus(value = HttpStatus.OK)
  @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
    try{
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
    }catch(BadCredentialsException e){
      // creer une Exception et l ajouter dans notre handler
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }
    User user = userService.readByUsername(loginRequest.getUsername());
    String token = jwtUtil.createToken(user);
    Bearer bearer = new Bearer(token);
    return ResponseEntity.ok().body(bearer);
  }
}

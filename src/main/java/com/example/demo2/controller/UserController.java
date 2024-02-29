
package com.example.demo2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.entities.User;
import com.example.demo2.services.UserService;

@RestController
@RequestMapping("user")
class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @ResponseStatus(value = HttpStatus.CREATED)
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public void create(@RequestBody User user) {
    this.userService.create(user);

  }

  @GetMapping
  public String getString() {
    return "ALL ACCOUNT";
  }
}

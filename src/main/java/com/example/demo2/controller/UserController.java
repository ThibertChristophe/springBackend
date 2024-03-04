
package com.example.demo2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<User> readAll() {
    return this.userService.readAll();
  }

  @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public User read(@PathVariable int id) {
    return this.userService.read(id);
  }

  @ResponseStatus(value = HttpStatus.CREATED)
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public void create(@RequestBody User user) {
    this.userService.create(user);
  }

  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void udate(@PathVariable int id, @RequestBody User user) {
    this.userService.update(id, user);
  }

  @GetMapping(path = "/login/{login}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> findByLogin(@PathVariable String login) {
    User user = this.userService.readByLogin(login);
    if (user == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    return ResponseEntity.status(HttpStatus.OK).body(user);
  }
}

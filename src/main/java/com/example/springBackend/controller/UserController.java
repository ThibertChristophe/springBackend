
package com.example.springBackend.controller;

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

import com.example.springBackend.entities.User;
import com.example.springBackend.services.UserService;

@RestController
@RequestMapping("user")
class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<User>> readAll() {
    return ResponseEntity.ok(this.userService.readAll());
  }

  @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> read(@PathVariable int id) {
    return ResponseEntity.ok(this.userService.read(id));
  }

  @ResponseStatus(value = HttpStatus.CREATED)
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public void create(@RequestBody User user) {
    this.userService.create(user);
  }

  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void update(@PathVariable int id, @RequestBody User user) {
    this.userService.update(id, user);
  }

  @GetMapping(path = "/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> findByUsername(@PathVariable String username) {
    User user = this.userService.readByUsername(username);
    if (user == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    return ResponseEntity.status(HttpStatus.OK).body(user);
  }
}

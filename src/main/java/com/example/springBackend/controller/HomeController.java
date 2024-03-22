package com.example.springBackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBackend.entities.Home;
import com.example.springBackend.services.HomeService;

@RestController
@RequestMapping(path = "home", produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeController {
  private final HomeService homeService;

  public HomeController(HomeService homeService) {
    this.homeService = homeService;
  }

  // Renvoi tout ou avec un filtre ?state=monEtat
  @GetMapping()
  public ResponseEntity<List<Home>> readAll(@RequestParam(required = false) String state) {
    return ResponseEntity.ok(this.homeService.readAll(state));
  }

  @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Home> read(@PathVariable int id) {
    Home home = this.homeService.read(id);
    return ResponseEntity.ok(home);
  }

  @ResponseStatus(value = HttpStatus.CREATED)
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public void create(@RequestBody Home home) {
    this.homeService.create(home);
  }

  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  @DeleteMapping()
  public void deleteAll() {
    this.homeService.deleteAll();
  }

  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  @DeleteMapping(path = "{id}")
  public void delete(@PathVariable int id) {
    this.homeService.deleteById(id);
  }

  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void update(@PathVariable int id, @RequestBody Home home) {
    this.homeService.update(id, home);
  }
}

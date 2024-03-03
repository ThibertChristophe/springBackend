package com.example.demo2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.entities.Home;
import com.example.demo2.services.HomeService;

@RestController
@RequestMapping(path = "home", produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeController {
  private final HomeService homeService;

  public HomeController(HomeService homeService) {
    this.homeService = homeService;
  }

  // Renvoi tout ou avec un filtre ?state=monEtat
  @GetMapping()
  public List<Home> readAll(@RequestParam(required = false) String state) {
    return this.homeService.readAll(state);
  }

  @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Home read(@PathVariable int id) {
    return this.homeService.read(id);
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
}

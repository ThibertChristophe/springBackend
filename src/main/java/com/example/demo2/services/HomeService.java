package com.example.demo2.services;

import java.util.List;
import java.util.Optional;

import com.example.demo2.entities.Home;
import com.example.demo2.repositories.HomeRepository;

public class HomeService {

  private final HomeRepository homeRepository;

  public HomeService(HomeRepository homeRepository) {
    this.homeRepository = homeRepository;
  }

  public void create(Home home) {
    this.homeRepository.save(home);
  }

  public List<Home> readAll() {
    return this.homeRepository.findAll();
  }

  public Home read(int id) {
    Optional<Home> optionalHome = this.homeRepository.findById(id);
    if (optionalHome.isPresent()) {
      return optionalHome.get();
    }
    return null;
  }
}

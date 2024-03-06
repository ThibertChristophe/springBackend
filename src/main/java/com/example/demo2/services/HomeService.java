package com.example.demo2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo2.entities.Home;
import com.example.demo2.entities.User;
import com.example.demo2.enums.TypeHome;
import com.example.demo2.exceptions.HomeNotFoundException;
import com.example.demo2.repositories.HomeRepository;

@Service
public class HomeService {

  private final UserService userService;

  private final HomeRepository homeRepository;

  public HomeService(UserService userService, HomeRepository homeRepository) {
    this.userService = userService;
    this.homeRepository = homeRepository;
  }

  public void create(Home home) {
    // On va chercher le user correspondant sinon on le cree.
    User user = userService.readOrCreate(home.getUser());
    home.setUser(user);
    // Par defaut on met type home
    home.setType(TypeHome.HOME);
    this.homeRepository.save(home);
  }

  public List<Home> readAll(String state) {
    // Ici bien tester le null pour tester si le param existe
    // Et ne pas tester si vide ("")
    if (state == null) {
      return this.homeRepository.findAll();

    }
    return this.homeRepository.findByState(state);
  }

  public Home read(int id) {
    Optional<Home> optionalHome = this.homeRepository.findById(id);
    if (optionalHome.isPresent()) {
      return optionalHome.get();
    }
    throw new HomeNotFoundException(id);
  }

  public void update(int id, Home home) {
    Home currentHome = this.read(id);
    if (currentHome != null) {
      currentHome = home;
      this.homeRepository.save(currentHome);
    }
  }

  public void deleteAll() {
    this.homeRepository.deleteAll();
  }

  public void deleteById(int id) {
    this.homeRepository.deleteById(id);
  }
}

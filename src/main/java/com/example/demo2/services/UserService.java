package com.example.demo2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo2.entities.User;
import com.example.demo2.repositories.UserRepository;

@Service
public class UserService {

  // Inject du repo
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void create(User user) {
    User userFound = this.userRepository.findByEmail(user.getEmail());
    if (userFound == null) {
      this.userRepository.save(user);
    }
  }

  public List<User> readAll() {
    return this.userRepository.findAll();
  }

  public User read(int id) {
    Optional<User> optionalUser = this.userRepository.findById(id);
    if (optionalUser.isPresent()) {
      return optionalUser.get();
    }
    return null;
  }

  public User readOrCreate(User user) {
    User userFound = this.userRepository.findByEmail(user.getEmail());
    if (userFound == null) {
      userFound = this.userRepository.save(user);
    }
    return userFound;
  }

  public void update(int id, User user) {
    User currentUser = this.read(id);
    if (currentUser != null) {
      currentUser = user;
      this.userRepository.save(currentUser);
    }
  }
}

package com.example.demo2.services;

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
    this.userRepository.save(user);
  }
}

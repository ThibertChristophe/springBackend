package com.example.springBackend.services;

import java.util.List;
import java.util.Optional;

import com.example.springBackend.entities.Role;
import com.example.springBackend.enums.TypeRole;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springBackend.entities.User;
import com.example.springBackend.exceptions.UserNotFoundException;
import com.example.springBackend.repositories.UserRepository;

@Service
public class UserService {

  // Inject du repo
  private final UserRepository userRepository;
  private final BCryptPasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
      this.passwordEncoder = passwordEncoder;
  }

  public void create(User user) {
    if(!user.getEmail().contains("@")) throw new RuntimeException("Email invalide");
    User userFound = this.userRepository.findByEmail(user.getEmail());
    if (userFound == null) {
      Role roleUser = new Role();
      roleUser.setTypeRole(TypeRole.USER);
      user.setRole(roleUser);
      user.setPassword(this.passwordEncoder.encode(user.getPassword()));
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
    throw new UserNotFoundException(id);
  }

  public User readByUsername(String username) {
    User userFound = this.userRepository.findByUsername(username);
    if (userFound == null)
      throw new UserNotFoundException();
    return userFound;
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
    } else {
      throw new UserNotFoundException(id);
    }
  }
}

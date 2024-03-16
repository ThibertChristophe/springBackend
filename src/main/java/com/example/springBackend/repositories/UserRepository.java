package com.example.springBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springBackend.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
  User findByEmail(String email);

  User findByLogin(String login);

}

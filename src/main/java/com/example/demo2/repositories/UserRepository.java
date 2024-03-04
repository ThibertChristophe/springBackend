package com.example.demo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
  User findByEmail(String email);

  User findByLogin(String username);

}

package com.example.springBackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springBackend.entities.Home;

public interface HomeRepository extends JpaRepository<Home, Integer> {
  List<Home> findByState(String state);
}

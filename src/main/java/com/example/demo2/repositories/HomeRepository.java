package com.example.demo2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.entities.Home;

public interface HomeRepository extends JpaRepository<Home, Integer> {
  List<Home> findByState(String state);
}

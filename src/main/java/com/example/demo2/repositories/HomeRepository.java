package com.example.demo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.entities.Home;

public interface HomeRepository extends JpaRepository<Home, Integer> {
}

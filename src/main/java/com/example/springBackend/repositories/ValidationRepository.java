package com.example.springBackend.repositories;

import com.example.springBackend.entities.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidationRepository extends JpaRepository<Validation, Integer> {
}

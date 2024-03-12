
package com.example.demo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}

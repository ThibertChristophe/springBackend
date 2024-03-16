
package com.example.springBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springBackend.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
  Booking findByUser_idAndHome_id(int user_id, int home_id);
}

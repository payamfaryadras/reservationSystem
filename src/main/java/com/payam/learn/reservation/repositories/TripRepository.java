package com.payam.learn.reservation.repositories;

import com.payam.learn.reservation.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TripRepository extends JpaRepository<Trip, UUID> {
}

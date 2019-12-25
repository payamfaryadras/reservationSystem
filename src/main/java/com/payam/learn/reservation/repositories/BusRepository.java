package com.payam.learn.reservation.repositories;

import com.payam.learn.reservation.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BusRepository extends JpaRepository<Bus, UUID> {
}

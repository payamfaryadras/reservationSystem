package com.payam.learn.reservation.repositories;

import com.payam.learn.reservation.model.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgencyRepository extends JpaRepository<Agency,UUID> {
}

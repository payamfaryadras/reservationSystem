package com.payam.learn.reservation.repositories;

import com.payam.learn.reservation.model.Stop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StopRepository  extends JpaRepository<Stop, UUID> {


}

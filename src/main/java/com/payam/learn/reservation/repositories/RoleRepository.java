package com.payam.learn.reservation.repositories;

import com.payam.learn.reservation.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByRole(String role);

}

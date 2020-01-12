package com.payam.learn.reservation;

import com.payam.learn.reservation.model.Role;
import com.payam.learn.reservation.repositories.RoleRepository;
import com.payam.learn.reservation.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReservationSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReservationSystemApplication.class);
    }

    @Bean
    CommandLineRunner init(RoleRepository roleRepository, UserRepository userRepository) {
        return args -> {
            //Create Admin and Passenger Roles

            Role adminRole = new Role();
            adminRole.setRole("ADMIN");
            roleRepository.save(adminRole);
        };
    }
}
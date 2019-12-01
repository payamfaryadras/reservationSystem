package com.payam.learn.reservation.services;

import com.payam.learn.reservation.model.Trip;
import com.payam.learn.reservation.repositories.TripRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DashboardServiceTest {

    @Autowired
    TripRepository tripRepository;
    private Trip trip = new Trip();
    @Test
    public void createTrips_shouldReturnSavedTrip() {
        var savedTrip = tripRepository.save(trip);
        assertThat(trip.equals(savedTrip));
    }
}
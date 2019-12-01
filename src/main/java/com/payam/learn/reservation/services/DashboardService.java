package com.payam.learn.reservation.services;


import com.payam.learn.reservation.repositories.TripRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    private final TripRepository tripRepository;

    public DashboardService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }



}

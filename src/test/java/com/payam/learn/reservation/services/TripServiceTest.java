package com.payam.learn.reservation.services;


import com.payam.learn.reservation.repositories.TripRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TripServiceTest {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private ReservationService reservationService;

//    @AfterEach
//    protected void tearDown(){
//        tripRepository.deleteAll();
//    }
//
////    @Test
////    public void find_all_trip(){
////
////        TripDto trip1 = new TripDto();
////        tripRepository.save(trip1);
////
////        List<TripDto> trips = tripRepository.findAll();
////
////        assertEquals(trips.size(),1);
////        assertEquals(trips.get(trips.size()-1).getId(),trip1.getId());
////    }
//
//    @Test
//    public  void save_trip(){
//        com.payam.learn.reservation.dto.model.TripDto tripDto = new com.payam.learn.reservation.dto.model.TripDto();
//        reservationService.addTrip(tripDto);
//        assertEquals(1.0,tripRepository.count());
//    }
}

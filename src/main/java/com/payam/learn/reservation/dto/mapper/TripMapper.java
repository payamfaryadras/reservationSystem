package com.payam.learn.reservation.dto.mapper;


import com.payam.learn.reservation.dto.model.TripDto;
import com.payam.learn.reservation.model.Trip;

public class TripMapper {
    public static TripDto toTripDto(Trip trip){
        return new TripDto()
                .setDestinationStop(trip.getDestination().getId().toString())
                .setSourceStop(trip.getSource().getId().toString())
                .setId(trip.getId().toString())
                .setDestinationStopName(trip.getDestination().getName())
                .setSourceStopName(trip.getSource().getName())
                .setFare(trip.getFare())
                .setBusDetail(trip.getBus().getDetail())
                .setJourneyTime(trip.getJourneyTime());


    }
}

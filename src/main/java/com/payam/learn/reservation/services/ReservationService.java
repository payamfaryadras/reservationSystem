package com.payam.learn.reservation.services;

import com.payam.learn.reservation.dto.model.AgencyDto;
import com.payam.learn.reservation.dto.model.BusDto;
import com.payam.learn.reservation.dto.model.StopDto;
import com.payam.learn.reservation.dto.model.TripDto;
import com.payam.learn.reservation.model.Agency;
import com.payam.learn.reservation.model.Stop;


import java.util.List;
import java.util.Set;
import java.util.UUID;


public interface ReservationService {


    TripDto addTrip(TripDto trip);

    List<StopDto> getAllStops();

    StopDto addStop(StopDto stop);

    Stop getStop(UUID uuid);

    List<TripDto> getAllTrip();


    List<BusDto> getAllBus();

    BusDto addBus(BusDto busDto);

    List<AgencyDto> getAllAgency();

    AgencyDto addAgency(AgencyDto agencyDto);


}

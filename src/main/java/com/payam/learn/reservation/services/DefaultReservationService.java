package com.payam.learn.reservation.services;

import com.payam.learn.reservation.dto.mapper.AgencyMapper;
import com.payam.learn.reservation.dto.mapper.BusMapper;
import com.payam.learn.reservation.dto.mapper.StopMapper;
import com.payam.learn.reservation.dto.mapper.TripMapper;
import com.payam.learn.reservation.dto.model.AgencyDto;
import com.payam.learn.reservation.dto.model.BusDto;
import com.payam.learn.reservation.dto.model.StopDto;
import com.payam.learn.reservation.dto.model.TripDto;
import com.payam.learn.reservation.model.Agency;
import com.payam.learn.reservation.model.Bus;
import com.payam.learn.reservation.model.Stop;
import com.payam.learn.reservation.model.Trip;
import com.payam.learn.reservation.repositories.AgencyRepository;
import com.payam.learn.reservation.repositories.BusRepository;
import com.payam.learn.reservation.repositories.StopRepository;
import com.payam.learn.reservation.repositories.TripRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DefaultReservationService implements ReservationService {
    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private StopRepository stopRepository;

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private AgencyRepository agencyRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    @Transactional
    public TripDto addTrip(TripDto tripDto) {
        Stop sourceStop = getStop(UUID.fromString(tripDto.getSourceStop()));
        Stop destinationStop = getStop(UUID.fromString(tripDto.getDestinationStop()));
        Bus bus = getBus(UUID.fromString(tripDto.getBusDetail()));
        if (!sourceStop.getId().equals(destinationStop)) {
            Trip trip = new Trip();
            trip.setSource(sourceStop);
            trip.setDestination(destinationStop);
            trip.setFare(tripDto.getFare());
            trip.setBus(bus);
            trip.setJourneyTime(tripDto.getJourneyTime());
            return TripMapper.toTripDto(tripRepository.save(trip));
        }
        throw new RuntimeException("");
    }

    private Bus getBus(UUID busCode) {
        Optional<Bus> bus = busRepository.findById(busCode);
        if (bus.isPresent()) {
            return bus.get();
        }
        //TODO
        throw new RuntimeException("");
    }


    @Override
    public List<StopDto> getAllStops() {
        return stopRepository.findAll().stream()
                .map(stop -> modelMapper.map(stop, StopDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StopDto addStop(StopDto stopDto) {
        if (!stopDto.getName().isEmpty() && !stopDto.getDescription().isEmpty()) {
            return StopMapper.
                    toStopDto(stopRepository
                            .save(StopMapper
                                    .toStop(stopDto)));
        }
        throw new RuntimeException("stop name and stop description should not be empty");
    }

    @Override
    public Stop getStop(UUID id) {
        Optional<Stop> stop = stopRepository.findById(id);
        if (stop.isPresent()) {
            return stop.get();
        }
//TODO
        throw new RuntimeException("");
    }

    @Override
    public List<TripDto> getAllTrip() {
        return tripRepository.findAll().stream()
                .map(trip -> modelMapper.map(trip, TripDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BusDto> getAllBus() {
        return busRepository.findAll().stream().map(bus ->
                modelMapper.map(bus, BusDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public BusDto addBus(BusDto busDto) {
        if (busDto.getCapacity() > 10 && (!busDto.getAgencyId().isEmpty())) {
            Agency agency = getAgency(busDto);
            Bus bus = BusMapper.toBus(busDto);
            bus.setAgency(agency);
            return BusMapper.toBusDto(busRepository.save(bus));
        }
        throw new RuntimeException("Capacity should be greater than 10!!!");
    }

    private Agency getAgency(BusDto busDto) {
        Optional<Agency> agency = agencyRepository.findById(UUID.fromString(busDto.getAgencyId()));
        if (agency.isPresent()) {
            return agency.get();
        }
        //TODO
        throw new RuntimeException("");
    }

    @Override
    public List<AgencyDto> getAllAgency() {
        return agencyRepository.findAll().stream().map(agency ->
                modelMapper.map(agency, AgencyDto.class)).collect(Collectors.toList());
    }

    @Override
    public AgencyDto addAgency(AgencyDto agencyDto) {
        if (agencyDto != null) {
            return AgencyMapper.toAgencyDto(agencyRepository.save(AgencyMapper.toAgency(agencyDto)));
        }
        throw new RuntimeException("agency cannot be null");
    }
}

package com.payam.learn.reservation.dto.mapper;

import com.payam.learn.reservation.dto.model.BusDto;
import com.payam.learn.reservation.model.Bus;

public class BusMapper {

    public static Bus toBus(BusDto busDto) {
        return new Bus().setCapacity(busDto.getCapacity())
                .setDetail(busDto.getDetail());

    }

    public static BusDto toBusDto(Bus bus) {
        return new BusDto().setId(bus.getId().toString())
                .setCapacity(bus.getCapacity())
                .setDetail(bus.getDetail())
                .setAgencyId(bus.getAgency().getId().toString())
                .setAgencyName(bus.getAgency().getName());
    }
}

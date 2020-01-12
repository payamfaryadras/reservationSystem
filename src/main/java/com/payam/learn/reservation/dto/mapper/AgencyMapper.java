package com.payam.learn.reservation.dto.mapper;

import com.payam.learn.reservation.dto.model.AgencyDto;
import com.payam.learn.reservation.model.Agency;

import java.util.UUID;

public class AgencyMapper {

    public static Agency toAgency(AgencyDto agencyDto) {
        return new Agency().setName(agencyDto.getName())
                .setDescription(agencyDto.getDescription());

    }

    public static AgencyDto toAgencyDto(Agency agency) {
        return new AgencyDto().setName(agency.getName())
                .setDescription(agency.getDescription())
                .setId(agency.getId().toString());
    }
}

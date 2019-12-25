package com.payam.learn.reservation.dto.mapper;

import com.payam.learn.reservation.dto.model.StopDto;
import com.payam.learn.reservation.model.Stop;

public class StopMapper {

    public static Stop toStop(StopDto stopDto){
        Stop stop = new Stop();
        stop.setName(stopDto.getName());
        stop.setDescription(stopDto.getDescription());
        return stop;
    }

    public static StopDto toStopDto(Stop stop){
        StopDto stopDto = new StopDto();
        stopDto.setId(stop.getId());
        stopDto.setName(stop.getName());
        stopDto.setDescription(stop.getDescription());
        return stopDto;
    }
}

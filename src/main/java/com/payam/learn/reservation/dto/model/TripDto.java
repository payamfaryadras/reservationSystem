package com.payam.learn.reservation.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Accessors(chain = true)
public class TripDto {

    private String id;
    @NotBlank
    private String sourceStop;
    @NotBlank
    private String destinationStop;
    private String sourceStopName;
    private String destinationStopName;
    @NotBlank
    private String busDetail;

    @Min(1)
    private int fare;

    @Min(1)
    private int journeyTime;


}

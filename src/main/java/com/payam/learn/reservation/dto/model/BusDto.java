package com.payam.learn.reservation.dto.model;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
public class BusDto {

    private String id;

    @Min(value = 10)
    private int capacity;
    @NotBlank
    private String detail;

}

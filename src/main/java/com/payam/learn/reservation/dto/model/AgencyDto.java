package com.payam.learn.reservation.dto.model;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
public class AgencyDto {

    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}

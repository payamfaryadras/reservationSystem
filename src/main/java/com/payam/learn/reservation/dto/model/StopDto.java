package com.payam.learn.reservation.dto.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@Getter
@Setter
public class StopDto {
    private UUID id;
    @NotBlank
    private  String name;
    @NotBlank
    private String description;

}

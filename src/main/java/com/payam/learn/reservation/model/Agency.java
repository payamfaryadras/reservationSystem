package com.payam.learn.reservation.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
@Entity
public class Agency {
    @Id
    private UUID id;

    private String name;

    private String description;

}

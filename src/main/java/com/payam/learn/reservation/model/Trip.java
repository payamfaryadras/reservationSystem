package com.payam.learn.reservation.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;
@Getter
@Setter
@Entity
public class Trip {
    @Id
    private UUID id;
    private final double fare;

    public Trip() {
        this.id = UUID.randomUUID();
        this.fare = 0;
    }

}

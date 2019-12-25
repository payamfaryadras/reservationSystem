package com.payam.learn.reservation.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Entity
public class Trip {
    @Id
    private UUID id;

    public Trip() {
        this.id = UUID.randomUUID();
    }

    @Setter
    @ManyToOne(optional = false)
    @JoinColumn(name = "source_stop_id", referencedColumnName = "id")
    private Stop source;
    @Setter
    @ManyToOne(optional = false)
    @JoinColumn(name = "destination_stop_id", referencedColumnName = "id")
    private Stop destination;
    @Setter
    private int fare;
    @Setter
    @ManyToOne(optional = false)
    @JoinColumn(name = "trip_bus_id", referencedColumnName = "id")
    private Bus bus;
    @Setter
    private int journeyTime;


}

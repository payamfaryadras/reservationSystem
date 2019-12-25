package com.payam.learn.reservation.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Stop {
    @Id
    private UUID id;
    private String name;
    private String description;
    public Stop (){
        this.id = UUID.randomUUID();
    }

    public Stop( String name, String description) {
        this.id = UUID.randomUUID();
        this.id = id;
        this.name = name;
        this.description = description;
    }
}

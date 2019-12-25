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
public class Bus {

    public Bus(){
        id =UUID.randomUUID();
    }

    @Id
    private UUID id;
    private String detail;

    private int capacity;


}

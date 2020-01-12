package com.payam.learn.reservation.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
@Entity
public class Agency {

    public Agency() {
        id = UUID.randomUUID();
    }

    @Id
    private UUID id;

    private String name;

    private String description;


    @OneToMany(mappedBy = "agency")
    private List<Bus> busList;

}

package com.payam.learn.reservation.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Data
@Accessors(chain = true)
public class Role {

    public Role() {
        this.id = UUID.randomUUID();
    }

    @Id
    private UUID id;
    private String role;

}

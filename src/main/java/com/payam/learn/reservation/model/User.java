package com.payam.learn.reservation.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Entity
@Getter
@Setter
@ToString(exclude = "password")
@Accessors(chain = true)
public class User {
    @Id
    private UUID id;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Role> roles;

    public User() {
        this.id = UUID.randomUUID();
    }

}

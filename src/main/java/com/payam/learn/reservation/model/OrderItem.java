package com.payam.learn.reservation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.servlet.http.PushBuilder;
import java.util.UUID;

@Entity
@Getter
@Setter
public class OrderItem {

    public OrderItem() {
        id = UUID.randomUUID();
    }

    @Id
    private UUID id;

    private long amount;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}

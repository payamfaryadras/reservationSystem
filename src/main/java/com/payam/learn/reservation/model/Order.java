package com.payam.learn.reservation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.servlet.http.PushBuilder;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity(name = "orders")
@Getter
@Setter
@Accessors(chain = true)
public class Order {

    public Order() {
        id = UUID.randomUUID();
    }

    @Id
    private UUID id;

    private String detail;
    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY)
    private Set<OrderItem> orderItems;


}

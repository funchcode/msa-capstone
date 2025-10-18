package com.example.order.core.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    private String id;
    private String status; // todo enum 변경
    private Long amount;
    private String customerId;
    @OneToMany(fetch = FetchType.EAGER)
    private List<OrderItem> items = new ArrayList<>();
    private Instant createdAt;

    public static Order create(String id, String customerId, List<OrderItem> items) {
        Order o = new Order();
        o.id = id;
        o.customerId = customerId;
        o.status = "PENDING";
        o.createdAt = Instant.now();
        items.forEach(item -> item.setOrder(o));
        o.items.addAll(items);
        o.items.stream().mapToLong(item -> item.getUnitPrice() * item.getQty()).sum();

        return o;
    }

}

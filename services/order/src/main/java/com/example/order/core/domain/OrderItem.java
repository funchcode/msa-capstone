package com.example.order.core.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private String sku;
    private Integer qty;
    @Column(name = "unit_price")
    private Long unitPrice;

    public OrderItem(String sku, int qty, long unitPrice) {
        this.sku = sku;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}

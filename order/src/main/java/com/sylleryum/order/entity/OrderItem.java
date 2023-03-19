package com.sylleryum.order.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDER_ITEMS")
@Entity
public class OrderItem implements Serializable {

    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "ADDRESS")
    private String address;

}

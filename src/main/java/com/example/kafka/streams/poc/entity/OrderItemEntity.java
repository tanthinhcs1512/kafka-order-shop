package com.example.kafka.streams.poc.entity;

import com.example.kafka.streams.poc.domain.entity.commercialorder.CommercialOrderLine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDER_ITEM")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private String id;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "PRICE", nullable=false, precision=19, scale=5)
    protected BigDecimal price;

    @Column(name = "QUANTITY")
    private int quantity;

    @ManyToOne(targetEntity = OrderEntity.class)
    @JoinColumn(name = "ORDER_ID")
    private OrderEntity order;

}

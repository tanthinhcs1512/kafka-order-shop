package com.example.kafka.streams.poc.entity;

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
@Table(name = "PRODUCT")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private String id;

    /** The name of the product */
    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE", nullable=false, precision=19, scale=5)
    protected BigDecimal price;

}

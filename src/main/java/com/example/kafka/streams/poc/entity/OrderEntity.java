package com.example.kafka.streams.poc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDER")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private String id;

    @Column(name = "DATE_TIME")
    @Temporal(TemporalType.DATE)
    private Date datetime;

    /** The member uuid of the order (client) */
    @Column(name = "MEMBER_ID")
    private String memberId;

    /** The addresses of the member */
    @OneToMany(mappedBy = "order", targetEntity = OrderItemEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderItemEntity> lines;

}

package com.example.kafka.streams.poc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PAYMENT")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private String id;

    @Column(name = "MEMBER_ID")
    private String memberId;

    @Column(name = "ORDER_ID")
    private String orderId;

    @Column(name = "PRICE", nullable=false, precision=19, scale=5)
    protected BigDecimal price;

    @Column(name = "PAYMENT_STATUS", nullable = false)
    private String status;

    @Column(name = "DATE_TIME")
    @Temporal(TemporalType.DATE)
    private Date datetime;

}

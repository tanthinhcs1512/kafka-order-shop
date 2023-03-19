package com.sylleryum.order.entity;

import com.sylleryum.common.util.OrderStatus;
import com.sylleryum.common.util.PaymentOrderStatus;
import com.sylleryum.common.util.StockStatus;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "ORDER")
public class Order {

    @Id
    private UUID id;

    @Column(name = "ORDER_NUMBER")
    private String orderNumber;

    @Column(name = "ORDER_STATUS", nullable = false)
    private String orderStatus = OrderStatus.NEW.getType();

    @Column(name = "STOCK_STATUS", nullable = false)
    private String stockStatus = StockStatus.UNKNOWN.getType();

    @Column(name = "PAYMENT_ORDER_STATUS", nullable = false)
    private String paymentStatus = PaymentOrderStatus.UNKNOWN.getType();

    @Column(name = "PAYMENT_STATUS_REASON")
    private String paymentStatusReason;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
}

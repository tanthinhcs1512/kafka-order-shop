package com.example.kafka.streams.poc.common.entity;

import com.example.kafka.streams.poc.common.util.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private String id;

    private Date datetime;

    private MemberDto memberDto;

    private BigDecimal orderPrice;

    private String stockStatus = OrderStatus.NEW.getType();

    private String stockStatusReason;

    private String paymentStatus = OrderStatus.NEW.getType();

    private String paymentStatusReason;

    private List<OrderItemDto> orderItemDtos = new ArrayList<>();

}

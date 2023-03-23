package com.example.kafka.streams.poc.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {

    private String id;

    private ProductDto productDto;

    protected BigDecimal price;

    private int quantity;

}

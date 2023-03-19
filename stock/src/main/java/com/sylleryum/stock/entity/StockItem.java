package com.sylleryum.stock.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "stock")
public class StockItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    private String itemNumber;

    @Indexed(unique = true)
    private String description;

    private long quantity;

}

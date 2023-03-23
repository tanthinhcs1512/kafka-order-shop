package com.example.kafka.streams.poc.entity;

import com.example.kafka.streams.poc.domain.entity.warehouse.WarehouseOrderLine;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Failed Warehouse order MongoDB entity
 */
@Document(collection="failedWarehouseOrderLine")
public class WarehouseOrderLineFailedEntity extends WarehouseOrderLineEntity {

    /**
     * Empty constructor
     */
    public WarehouseOrderLineFailedEntity() {
    }

    /**
     * Copy constructor from domain entity
     *
     * @param source the source purchase order object
     */
    public WarehouseOrderLineFailedEntity(WarehouseOrderLine source) {
        super(source);
    }
}

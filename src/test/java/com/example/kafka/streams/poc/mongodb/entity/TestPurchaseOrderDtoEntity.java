package com.example.kafka.streams.poc.mongodb.entity;

import com.example.kafka.streams.poc.domain.entity.purchaseorder.PurchaseOrder;
import com.example.kafka.streams.poc.domain.entity.purchaseorder.PurchaseOrderLineCondensed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for purchase order mongoDB entity
 */
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TestPurchaseOrderDtoEntity {

    @Test
    public void testEmptyConstructor() {

        PurchaseOrderEntity purchaseOrderEntity = new PurchaseOrderEntity();

        assertNull(purchaseOrderEntity.getUuid());
        assertNull(purchaseOrderEntity.getAggregationKey());
        assertNull(purchaseOrderEntity.getCountry());
        assertNull(purchaseOrderEntity.getDate());
        assertEquals(0f, purchaseOrderEntity.getTotalAmount(), 0.001);
        assertEquals(0, purchaseOrderEntity.getTotalQuantity());
        assertNotNull(purchaseOrderEntity.getLines());
    }

    @Test
    public void testCopyConstructor() {

        List<PurchaseOrderLineCondensed> lines = new ArrayList<>();
        PurchaseOrderLineCondensed line = PurchaseOrderLineCondensed.newBuilder().setUuid("121").build();
        lines.add(line);

        PurchaseOrder purchaseOrder = new PurchaseOrder("101", "102", "103", new Date(104), 105f, 106, lines);
        PurchaseOrderEntity purchaseOrderEntity = new PurchaseOrderEntity(purchaseOrder);

        assertEquals("101", purchaseOrderEntity.getUuid());
        assertEquals("102", purchaseOrderEntity.getAggregationKey());
        assertEquals("103", purchaseOrderEntity.getCountry());
        assertEquals(104, purchaseOrderEntity.getDate().getTime());
        assertEquals(105f, purchaseOrderEntity.getTotalAmount(), 0.001);
        assertEquals(106, purchaseOrderEntity.getTotalQuantity());
        assertEquals("121", purchaseOrderEntity.getLines().get(0).getUuid());
    }
}

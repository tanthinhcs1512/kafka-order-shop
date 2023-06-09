package com.example.kafka.streams.poc.mongodb.entity;

import com.example.kafka.streams.poc.domain.entity.purchaseorder.PurchaseOrderLineCondensed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Unit test for purchase order line mongoDB entity
 */
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TestPurchaseOrderDtoLineCondensedEntity {

    @Test
    public void testEmptyConstructor() {

        PurchaseOrderLineCondensedEntity purchaseOrderLineEntity = new PurchaseOrderLineCondensedEntity();

        assertNull(purchaseOrderLineEntity.getUuid());
        assertNull(purchaseOrderLineEntity.getAggregationKey());
        assertNull(purchaseOrderLineEntity.getProductUuid());
        assertEquals(0, purchaseOrderLineEntity.getPrice(), 0.001);
        assertEquals(0, purchaseOrderLineEntity.getQuantity());
    }

    @Test
    public void testCopyConstructor() {

        PurchaseOrderLineCondensed purchaseOrderLine = new PurchaseOrderLineCondensed("101", "102", "103", 104f, 105);
        PurchaseOrderLineCondensedEntity purchaseOrderLineEntity = new PurchaseOrderLineCondensedEntity(purchaseOrderLine);

        assertEquals("101", purchaseOrderLineEntity.getUuid());
        assertEquals("102", purchaseOrderLineEntity.getAggregationKey());
        assertEquals("103", purchaseOrderLineEntity.getProductUuid());
        assertEquals(104f, purchaseOrderLineEntity.getPrice(), 0.001);
        assertEquals(105, purchaseOrderLineEntity.getQuantity());
    }
}

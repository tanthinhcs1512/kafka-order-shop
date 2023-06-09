package com.example.kafka.streams.poc.domain.entity.commercialorder;

import com.example.kafka.streams.poc.domain.entity.product.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for CommercialOrderLine.Builder class
 */
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TestCommercialOrderDtoLineExporter {

    @Test
    public void testExport() {

        Product product = new Product("111", "112", "113", "114", 115f);
        CommercialOrderLine line = CommercialOrderLine.newBuilder()
                .setUuid("101")
                .setCommercialOrderUuid("102")
                .setProduct(product)
                .setPrice(104f)
                .setQuantity(105)
                .build();

        com.example.kafka.streams.poc.schemas.order.CommercialOrderLine avroLine
                = CommercialOrderLine.newAvroExporter(line).export();

        assertEquals("101", avroLine.getUuid());
        assertEquals("102", avroLine.getCommercialOrderUuid());
        assertEquals("111", avroLine.getProductUuid());
        assertEquals(104f, line.getPrice(), 0.001);
        assertEquals(105, line.getQuantity());
    }
}

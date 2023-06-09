package com.example.kafka.streams.poc.service.generator.commercialorder;

import com.example.kafka.streams.poc.domain.entity.commercialorder.CommercialOrder;
import com.example.kafka.streams.poc.domain.entity.commercialorder.CommercialOrderLine;
import com.example.kafka.streams.poc.service.generator.address.RandomAddressGenerator;
import com.example.kafka.streams.poc.service.generator.member.RandomMemberGenerator;
import com.example.kafka.streams.poc.service.generator.member.ReusableMemberSelector;
import com.example.kafka.streams.poc.service.generator.product.RandomProductGenerator;
import com.example.kafka.streams.poc.service.generator.product.ReusableProductSelector;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for RandomCommercialOrderGenerator service
 */
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TestRandomCommercialOrderDtoGenerator {

    @Test
    public void testGetCommercialOrderReturnCommercialOrderWithRandomData() {

        RandomCommercialOrderGenerator service = getCommercialOrderGenerator();
        CommercialOrder commercialOrder = service.getCommercialOrder();

        assertNotNull(commercialOrder);
        assertNotNull(commercialOrder.getUuid());
        assertNotNull(commercialOrder.getDatetime());
        assertNotNull(commercialOrder.getMember());
        assertNotNull(commercialOrder.getShippingAddress());

        List<CommercialOrderLine> lines = commercialOrder.getLines();
        assertTrue(lines.size() > 0);
        assertTrue(lines.size() < 11);
        for (CommercialOrderLine line : lines) {
            assertTrue(line.getPrice() > line.getProduct().getPrice());
        }
    }

    @Test
    public void testGetCommercialOrderReturnShippingAddress() {

        RandomCommercialOrderGenerator service = getCommercialOrderGenerator();
        CommercialOrder commercialOrder;
        do {
            commercialOrder = service.getCommercialOrder();
        }
        while (commercialOrder.getBillingAddress() == null);

        assertNotNull(commercialOrder.getBillingAddress());
    }

    /**
     * @return a RandomCommercialOrderGenerator service for testing purposes
     */
    private RandomCommercialOrderGenerator getCommercialOrderGenerator() {
        return new RandomCommercialOrderGenerator(
                new ReusableMemberSelector(new RandomMemberGenerator(new RandomAddressGenerator())),
                new ReusableProductSelector(new RandomProductGenerator())
        );
    }
}

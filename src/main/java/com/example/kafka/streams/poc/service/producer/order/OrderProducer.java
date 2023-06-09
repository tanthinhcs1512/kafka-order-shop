package com.example.kafka.streams.poc.service.producer.order;

import com.example.kafka.streams.poc.domain.entity.member.Member;
import com.example.kafka.streams.poc.domain.entity.commercialorder.CommercialOrder;
import com.example.kafka.streams.poc.domain.entity.commercialorder.CommercialOrderLine;
import com.example.kafka.streams.poc.domain.entity.product.Product;
import com.example.kafka.streams.poc.kafka.producer.NewCommercialOrdersKafkaProducer;
import com.example.kafka.streams.poc.kafka.producer.NewMembersKafkaProducer;
import com.example.kafka.streams.poc.kafka.producer.NewProductsKafkaProducer;
import com.example.kafka.streams.poc.service.generator.commercialorder.CommercialOrderGeneratorInterface;
import com.example.kafka.streams.poc.service.producer.exception.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service to produce one or more commercial order with random data
 */
@Service
public class OrderProducer {

    /** Service to generate a commercial order with random data */
    private CommercialOrderGeneratorInterface commercialOrderGenerator;

    /** Kafka producer to publish the new commercial orders data */
    private NewCommercialOrdersKafkaProducer newCommercialOrdersKafkaProducer;

    /** Kafka producer to publish the new members data */
    private NewMembersKafkaProducer newMembersKafkaProducer;

    /** Kafka producer to publish the new products data */
    private NewProductsKafkaProducer newProductsKafkaProducer;

    /**
     * Autowired constructor
     *
     * @param commercialOrderGenerator         Service to generate a commercial order with random data
     * @param newCommercialOrdersKafkaProducer Kafka producer to publish the new commercial orders data
     * @param newMembersKafkaProducer          Kafka producer to publish the new members data
     * @param newProductsKafkaProducer         Kafka producer to publish the new products data
     */
    @Autowired
    public OrderProducer(
            CommercialOrderGeneratorInterface commercialOrderGenerator,
            NewCommercialOrdersKafkaProducer newCommercialOrdersKafkaProducer,
            NewMembersKafkaProducer newMembersKafkaProducer,
            NewProductsKafkaProducer newProductsKafkaProducer
    ) {
        this.commercialOrderGenerator = commercialOrderGenerator;
        this.newCommercialOrdersKafkaProducer = newCommercialOrdersKafkaProducer;
        this.newMembersKafkaProducer = newMembersKafkaProducer;
        this.newProductsKafkaProducer = newProductsKafkaProducer;
    }

    /**
     * Executes the service
     *
     * @param count the number of commercial orders to produce (1-500)
     * @return the list of the commercial orders produceed
     */
    public List<CommercialOrder> produce(int count) {

        if (count < 1 || count > 500) {
            throw new InvalidArgumentException("The count of commercial orders to create must be between 1 and 500!");
        }

        // Create the commercial orders and publis members and products to Kafka
        List<CommercialOrder> commercialOrders = new ArrayList<>();
        while (count-- > 0) {
            CommercialOrder commercialOrder = commercialOrderGenerator.getCommercialOrder();
            publishMemberFromCommercialOrder(commercialOrder);
            publishProductsFromCommercialOrder(commercialOrder);
            commercialOrders.add(commercialOrder);
        }

        // Sleep the thread for 100 millisecs to avoid publishing first the commercial-orders
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Publish the commercial orders
        for (CommercialOrder commercialOrder : commercialOrders) {
            publishCommercialOrder(commercialOrder);
        }

        return commercialOrders;
    }

    /**
     * Publishes the commercial order data into a Kafka topic
     *
     * @param commercialOrder the commercial order data
     */
    private void publishCommercialOrder(CommercialOrder commercialOrder) {
        newCommercialOrdersKafkaProducer.publish(CommercialOrder.newAvroExporter(commercialOrder).export());
    }

    /**
     * Publishes the member of the comercial order into a Kafka topic
     *
     * @param commercialOrder the commercial order data
     */
    private void publishMemberFromCommercialOrder(CommercialOrder commercialOrder) {
        newMembersKafkaProducer.publish(Member.newAvroExporter(commercialOrder.getMember()).export());
    }

    /**
     * Publishes all the products of the comercial order lines into a Kafka topic
     *
     * @param commercialOrder the commercial order data
     */
    private void publishProductsFromCommercialOrder(CommercialOrder commercialOrder) {
        for (CommercialOrderLine line : commercialOrder.getLines()) {
            newProductsKafkaProducer.publish(Product.newAvroExporter(line.getProduct()).export());
        }
    }
}

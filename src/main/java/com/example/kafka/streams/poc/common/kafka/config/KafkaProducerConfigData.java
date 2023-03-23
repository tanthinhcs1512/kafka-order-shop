package com.example.kafka.streams.poc.common.kafka.config;

import lombok.Data;

@Data
public class KafkaProducerConfigData {

    private String keySerializerClass;

    private String valueSerializerClass;

    private String compressionType;

    private String acks;

    private Integer batchSize;

    private Integer batchSizeBoostFactor;

    private Integer lingerMs;

    private Integer requestTimeoutMs;

    private Integer retryCount;
}

package com.sylleryum.common.kafka.model;
@org.apache.avro.specific.AvroGenerated
public enum PaymentOrderStatus implements org.apache.avro.generic.GenericEnumSymbol<PaymentOrderStatus> {
  PENDING, CANCELLED  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"PaymentOrderStatus\",\"namespace\":\"com.sylleryum.common.kafka.model\",\"symbols\":[\"PENDING\",\"CANCELLED\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}

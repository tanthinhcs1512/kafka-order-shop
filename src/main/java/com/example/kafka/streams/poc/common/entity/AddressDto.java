package com.example.kafka.streams.poc.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private String id;

    /** The Alpha-2 ISO 3166 country code */
    private String country;

    /** The state, province or department */
    private String state;

    /** The name of the city */
    private String city;

    /** The zip code */
    private String zipCode;

    /** The name of the street */
    private String street;

}

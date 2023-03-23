package com.example.kafka.streams.poc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private String id;

    /** The Alpha-2 ISO 3166 country code */
    @Column(name = "COUNTRY")
    private String country;

    /** The state, province or department */
    @Column(name = "STATE")
    private String state;

    /** The name of the city */
    @Column(name = "CITY")
    private String city;

    /** The zip code */
    @Column(name = "ZIPCODE")
    private String zipCode;

    /** The name of the street */
    @Column(name = "STREET")
    private String street;

    @ManyToOne(targetEntity = MemberEntity.class)
    @JoinColumn(name = "MEMBER_ID")
    private MemberEntity member;

}

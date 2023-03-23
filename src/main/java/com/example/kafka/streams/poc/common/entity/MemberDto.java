package com.example.kafka.streams.poc.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

    private String id;

    private String firstName;

    private String lastName;

    List<AddressDto> addresses = new ArrayList<>();

}

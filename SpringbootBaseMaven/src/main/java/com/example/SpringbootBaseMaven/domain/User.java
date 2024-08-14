package com.example.SpringbootBaseMaven.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private String country;
    private String occupation;
    private double salary;
}


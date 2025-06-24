package com.example.batch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int index;
    private String customerId;

    private String firstName;
    private String lastName;
    private String company;
    private String city;
    private String country;

    private String phone1;
    private String phone2;
    private String email;
    private String subscriptionDate;
    private String website;

    private String fullName;
}

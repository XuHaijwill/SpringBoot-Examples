package com.example.batch.processor;

import com.example.batch.entity.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {
    @Override
    public Customer process(Customer customer) throws Exception {
        customer.setFullName(String.join(" ", customer.getFirstName(), customer.getLastName()));
        return customer;
    }
}

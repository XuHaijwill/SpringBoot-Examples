package com.company.myloyal.repository;

import com.company.myloyal.domain.Customer;
import com.company.myloyal.exception.NotFoundException;
import com.company.myloyal.util.CustomerUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * test
 */
@Repository
public class CustomerRepository {

    @Autowired
    private CustomerUtil customerUtil;

    private static Customer customer;

    @PostConstruct
    public void initData() {

        customer = customerUtil.get();
    }

    public Customer findCustomer(String id) throws NotFoundException {

        if(!id.equals("1")) {
            throw new NotFoundException("404", "Customer does not exist");
        }

        return customer;
    }
}

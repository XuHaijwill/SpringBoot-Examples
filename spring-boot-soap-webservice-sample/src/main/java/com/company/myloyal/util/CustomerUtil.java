package com.company.myloyal.util;

import com.company.myloyal.domain.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;


/**
 * test
 */
@Component
public class CustomerUtil {

    private static final Customer customer = new Customer();

    @PostConstruct
    public void initData() {
        customer.setId("1");
        customer.setTitle(Title.MR);
        customer.setName("John");
        customer.setSurname("Smith");
        customer.setDateOfBirth("1970-01-20");
        customer.getTelephoneContactNum().add(createTelephone());
        customer.setAddress(createAddress());
    }

    private Telephone createTelephone() {
        Telephone tel = new Telephone();
        tel.setTelephoneType(TelephoneType.HOME);
        tel.setCountryCode("+44");
        tel.setNumber("02049490303");
        return tel;
    }

    private Address createAddress() {
        Address addr = new Address();
        addr.setAddressLine1("Flat 1, 22 Test Building");
        addr.setAddressLine2("Shoreditch High Street");
        addr.setCity("London");
        addr.setPostCode("E1 030");
        addr.setCountryCode("UK");
        return addr;
    }

    public Customer get() {
        return customer;
    }
}

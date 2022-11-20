package com.spring.boilerplate.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.boilerplate.api.model.dto.CustomerDto;
import com.spring.boilerplate.api.model.entity.Customer;

public class TestDataHelper {

    private static final String FIRST_NAME1 = "Santhosh";
    private static final String LAST_NAME1 = "Vernekar";
    private static final String TITLE = "Mr";

    private static final String TEST_EMAIL = "TEST_EMAIL@Email.com";
    private static final String TEST_PHONE_NUMBER = "123456789";

    public static final Long CUSTOMER_ID_FOR_NEW_BANK_ACCOUNT = 1L;

    public static final ObjectMapper MAPPER = new ObjectMapper();

    public static CustomerDto getCustomer1() {
        return CustomerDto.builder()
                .firstName(FIRST_NAME1)
                .lastName(LAST_NAME1)
                .title(TITLE)
                .email(TEST_EMAIL)
                .phoneNumber(TEST_PHONE_NUMBER)
                .build();
    }


    public static Customer getNewCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("User");
        customer.setLastName("User");
        customer.setEmail("User@email.com");
        customer.setTitle("Mrs");
        return customer;
    }
}

package com.spring.boilerplate.api.service;

import com.spring.boilerplate.api.model.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getCustomerList();

    Customer getCustomer(Long customerId);

    Customer saveCustomer(Customer customer);
}

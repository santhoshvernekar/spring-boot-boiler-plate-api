package com.spring.boilerplate.api.service.impl;

import com.google.common.base.Preconditions;
import com.spring.boilerplate.api.exception.ManagerException;
import com.spring.boilerplate.api.model.entity.Customer;
import com.spring.boilerplate.api.repository.CustomerRepository;
import com.spring.boilerplate.api.service.ICustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {

    private static final String MESSAGE_FORMAT_NO_CUSTOMER = "No customer by customerId: %d";

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomerList() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Long customerId) {
        Preconditions.checkNotNull(customerId, MESSAGE_FORMAT_NO_CUSTOMER, customerId);
        return customerRepository.findById(customerId)
                .orElseThrow(() -> ManagerException.to("** Customer not found for id :: " + customerId));
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Preconditions.checkNotNull(customer, "customer object doesn't exist");
        Customer savedCustomer = customerRepository.save(customer);
        log.info("Customer saved by id: {}", savedCustomer.getId());
        return savedCustomer;
    }
}

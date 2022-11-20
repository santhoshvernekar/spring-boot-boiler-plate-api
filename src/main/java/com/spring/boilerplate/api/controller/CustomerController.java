package com.spring.boilerplate.api.controller;

import com.spring.boilerplate.api.model.dto.CustomerDto;
import com.spring.boilerplate.api.model.dto.CustomerList;
import com.spring.boilerplate.api.model.dto.StatusResponse;
import com.spring.boilerplate.api.model.entity.Customer;
import com.spring.boilerplate.api.service.ICustomerService;
import com.spring.boilerplate.api.service.impl.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/v1/customers")
@RestController
public class CustomerController {

    private final ICustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(description = "Retrieve All Accounts")
    @GetMapping
    public ResponseEntity<CustomerList> getAllCustomers() {
        CustomerList list = new CustomerList();
        list.setItems(customerService.getCustomerList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Operation(description = "Retrieve customer by given customerId")
    @GetMapping(value = "/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable(name = "customerId") Long customerId) {
        Customer customer = customerService.getCustomer(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @Operation(description = "Create a new customer")
    @PostMapping
    public ResponseEntity<StatusResponse> saveCustomer(@RequestBody @Valid CustomerDto customer) {
        customerService.saveCustomer(Customer.fromDto(customer));
        return new ResponseEntity<>(new StatusResponse("Created Successfully"), HttpStatus.OK);
    }


}

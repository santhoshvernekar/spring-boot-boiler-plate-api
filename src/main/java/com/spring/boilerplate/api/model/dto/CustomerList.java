package com.spring.boilerplate.api.model.dto;

import com.spring.boilerplate.api.model.entity.Customer;
import lombok.Data;

import java.util.List;

@Data
public class CustomerList {
    List<Customer> items;
}


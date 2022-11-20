package com.spring.boilerplate.api.utils;

import com.spring.boilerplate.api.model.entity.Customer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class UtilityHelper {

    private UtilityHelper() {
    }

    public static final Supplier<List<Customer>> customerSupplier = () -> {

        Customer customer1 = new Customer();
        customer1.setFirstName("Santhosh");
        customer1.setLastName("Vernekar");
        customer1.setEmail("santhosh@email.com");
        customer1.setTitle("Mr");
        customer1.setPhoneNumber("123456789");

        Customer customer2 = new Customer();

        customer2.setFirstName("Ram");
        customer2.setLastName("S");
        customer2.setEmail("Ram@email.com");
        customer2.setTitle("Mr");
        customer2.setPhoneNumber("123456780");

        Customer customer3 = new Customer();
        customer3.setFirstName("Naveen");
        customer3.setLastName("M");
        customer3.setEmail("naveen@email.com");
        customer3.setTitle("Mr");
        customer2.setPhoneNumber("123456980");

        return Arrays.asList(customer1, customer2, customer3);

    };

}

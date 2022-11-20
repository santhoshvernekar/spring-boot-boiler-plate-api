package com.spring.boilerplate.api;

import com.spring.boilerplate.api.model.entity.Customer;
import com.spring.boilerplate.api.repository.CustomerRepository;
import com.spring.boilerplate.api.utils.UtilityHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;


@Slf4j
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
@EnableJpaAuditing
public class SpringBootMain {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMain.class, args);
    }

    @Autowired
    private CustomerRepository customerRepository;


    @Bean
    CommandLineRunner runner() {
        return args -> {

            List<Customer> customers = customerRepository.findAll();

            if (customers.isEmpty()) {
                log.info("******* Inserting customers to DB *******");
                customerRepository.saveAll(UtilityHelper.customerSupplier.get());
            } else {
                log.info("******* Customers stored in DB Size :: {}", customers.size());
                log.info("******* Customers stored in DB :: {}", customers);
            }
        };
    }

}

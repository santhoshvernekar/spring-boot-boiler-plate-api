package com.spring.boilerplate.api.repository;

import com.spring.boilerplate.api.model.entity.Customer;
import com.spring.boilerplate.api.utils.TestDataHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@DataJpaTest
@RunWith(SpringRunner.class)
public class CustomerRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private CustomerRepository customerRepository;

    private final int existingLength = 3;

    @Test
    public void test_Find_All() {

        List<Customer> customerList = customerRepository.findAll();
        Assert.assertEquals(customerList.size(), existingLength);
    }

    @Test
    public void test_Find_All_After_Insertion() {
        customerRepository.save(TestDataHelper.getNewCustomer());
        List<Customer> customerList = customerRepository.findAll();
        Assert.assertEquals(customerList.size(), existingLength + 1);
    }

}

package com.spring.boilerplate.api.controller;

import com.spring.boilerplate.api.service.impl.CustomerService;
import com.spring.boilerplate.api.utils.TestDataHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTest {


    @Mock
    private CustomerService customerService;

    private MockMvc resource;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        CustomerController customerController = new CustomerController(customerService);
        resource = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void should_get_Customer_List() throws Exception {
        String target = "/api/v1/customers";
        resource.perform(get(target)).andExpect(status().is2xxSuccessful()).andDo(print()).andReturn();
    }

    @Test
    public void should_get_Customer_ById() throws Exception {
        String target = "/api/v1/customers/1";
        resource.perform(get(target)).andDo(print()).
                andExpect(status().is2xxSuccessful()).andDo(print()).andReturn();
    }

    @Test
    public void should_Insert_Customer() throws Exception {
        String target = "/api/v1/customers";

        resource.perform(post(target)
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestDataHelper.MAPPER.writeValueAsString(TestDataHelper.getCustomer1())))
                .andExpect(status().is2xxSuccessful())
                .andDo(print()).andReturn();
    }
}

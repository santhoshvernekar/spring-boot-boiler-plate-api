package com.spring.boilerplate.api.stepdefs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        tags = "@sanity",
        plugin = {"pretty", "html:target/cucumber/"})

public class CucumberIntegrationTest {
}

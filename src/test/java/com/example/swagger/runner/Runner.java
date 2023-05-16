package com.example.swagger.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        publish = true,
        stepNotifications = true,
        features = "src/test/resources/features",
        glue = "com.example.swagger.glue",
        tags = "@METODOS")

public class Runner {
}

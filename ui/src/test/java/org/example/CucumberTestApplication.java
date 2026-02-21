package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.example", "stepDefinition", "hooks", "Drivers"})
public class CucumberTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CucumberTestApplication.class, args);
    }
}
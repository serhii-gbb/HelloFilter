package com.filter.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@PropertySource(value = "classpath:application.properties")
public class HelloFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloFilterApplication.class, args);
    }

}



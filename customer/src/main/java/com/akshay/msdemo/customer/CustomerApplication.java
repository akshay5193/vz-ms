package com.akshay.msdemo.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.akshay.msdemo.customer")
public class CustomerApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerApplication.class, args);
        System.out.println("Hey Ramo!!!");
    }

}

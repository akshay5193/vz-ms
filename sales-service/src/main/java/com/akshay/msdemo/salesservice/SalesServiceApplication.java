package com.akshay.msdemo.salesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.akshay.msdemo.salesservice")
public class SalesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesServiceApplication.class, args);
    }

}

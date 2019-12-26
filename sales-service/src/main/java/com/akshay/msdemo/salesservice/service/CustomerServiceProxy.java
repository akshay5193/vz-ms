package com.akshay.msdemo.salesservice.service;

import com.akshay.msdemo.salesservice.model.Customer;
import com.akshay.msdemo.salesservice.model.SalesOrder;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(name="customer-service", url="localhost:8000")
@FeignClient(name="customer-service")       // you do not need the url while using the Ribbon load balancing
@RibbonClient(name = "customer-service")
public interface CustomerServiceProxy  {

    default void show()
    {
        System.out.println("Default Method Executed");
    }

    @GetMapping("/customers/{email}")
    public Customer getCustomerByEmail(@PathVariable("email") String email);

    @GetMapping("/customers")
    public List<Customer> getAllCustomers();

}

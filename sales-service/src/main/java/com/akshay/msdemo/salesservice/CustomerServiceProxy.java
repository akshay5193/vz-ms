package com.akshay.msdemo.salesservice;

import com.akshay.msdemo.salesservice.model.SalesOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="customer-service", url="localhost:8000")
public interface CustomerServiceProxy  {

    @GetMapping("/customers/{email}")
    public SalesOrder getCustomerByEMail(@PathVariable("email") String email);

}

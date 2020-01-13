package com.akshay.msdemo.salesservice.service;

import com.akshay.msdemo.salesservice.model.Customer;
import com.akshay.msdemo.salesservice.model.Item;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
public class CustomerHystrixFallback implements CustomerServiceProxy, ItemProxy {

    @Override
    public Customer getCustomerByEmail(String email){
        System.out.println("customer service is currently down...");
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        System.out.println("customer service is currently down...");
        return null;
    }

    @Override
    public Item findItemByName(String name) {
        System.out.println("ITEM service is currently down...");
        return  null;
    }

    @Override
    public Item retrieveConfiguration() {
        System.out.println("There was some error in ITEM service...");
        return null;
    }

}

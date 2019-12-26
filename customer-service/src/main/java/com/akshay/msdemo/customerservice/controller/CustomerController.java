package com.akshay.msdemo.customerservice.controller;

import com.akshay.msdemo.customerservice.model.Customer;
import com.akshay.msdemo.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RefreshScope
@RestController
//@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/customers/{email}")
    public Customer getCustomerByEmail(@PathVariable("email") String email) {
        Customer customerWithEmail = customerService.findByEmail(email);
        return customerWithEmail;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = customerService.findAllCustomers();
        return allCustomers;
    }


    @PostMapping("/customers/add")
    public Customer addCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("failed to create customer...");
            return null;
        } else {
            System.out.println("Customer created..." + customer.getCreateAt());
            return customerService.addNewCustomer(customer);
        }
    }

}

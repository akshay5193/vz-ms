package com.akshay.msdemo.customer.controller;

import com.akshay.msdemo.customer.model.Customer;
import com.akshay.msdemo.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/{email}")
    public Customer getAllCustomers(@PathVariable("email") String email) {
        Customer customerWithEmail = customerService.findByEmail(email);
        return customerWithEmail;
    }

    @GetMapping("/")
    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = customerService.findAllCustomers();
        return allCustomers;
    }

//    CONFIG SERVER TESTING . . .
//    @GetMapping("/test")
//    public String getAllCustomers() {
//        List<Customer> allCustomers = customerService.findAllCustomers();
//        System.out.println(message);
//        return message;
//    }

//    @RequestParam(value = "first_name")String first_name,
//    @RequestParam(value = "last_name") String last_name,
//    @RequestParam(value = "email") String email

    @PostMapping("/add")
    public Customer addCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("failed to create customer...");
            return null;
        } else {
            System.out.println("Customer created...");
            return customerService.addNewCustomer(customer);
        }
    }

}

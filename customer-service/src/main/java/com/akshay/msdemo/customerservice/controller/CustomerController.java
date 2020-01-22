package com.akshay.msdemo.customerservice.controller;

import com.akshay.msdemo.customerservice.exceptions.CustomerNotFoundException;
import com.akshay.msdemo.customerservice.model.Customer;
import com.akshay.msdemo.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Cacheable(value = "customer", key = "#email")
    @GetMapping(value = "/{email}", produces = "application/json")
    public Customer getCustomerByEmail(@PathVariable("email") String email) {
        System.out.println("in controller function...");
        Customer customerWithEmail = customerService.findByEmail(email);
        if (customerWithEmail == null) {
            System.out.println("customer with email: " + email + " not found...");
            throw new CustomerNotFoundException("email - " + email);
        }
        return customerWithEmail;
    }

    @GetMapping(value = "/", produces = "application/json")
    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = customerService.findAllCustomers();
        return allCustomers;
    }


    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Object> addCustomer(@Valid @RequestBody Customer customer) {
            Customer savedCustomer = customerService.addNewCustomer(customer);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedCustomer.getId())
                    .toUri();
            return ResponseEntity.created(location).build();
//        }
    }

    @DeleteMapping("/remove/{id}")
    public void removeCustomer(@PathVariable("id") Long id) {
        Customer customer = customerService.deleteCustomerById(id);
        if (customer == null) {
            throw new CustomerNotFoundException("id - " + id);
        }
    }

}

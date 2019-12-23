package com.akshay.msdemo.customer.service;

import com.akshay.msdemo.customer.model.Customer;
import com.akshay.msdemo.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer findByEmail(String email) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(email);
        if (optionalCustomer.isPresent()) {
            System.out.println("customer with email " + email + " found!!!");
            return optionalCustomer.get();
        } else {
            System.out.println("customer with email " + email + " NOT FOUND!!!");
            return null;
        }
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer addNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

}

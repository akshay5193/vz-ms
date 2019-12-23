package com.akshay.msdemo.customerservice.repository;


import com.akshay.msdemo.customerservice.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findAll();

    Optional<Customer> findByEmail(String email);

}

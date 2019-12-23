package com.akshay.msdemo.customer.repository;

import com.akshay.msdemo.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findAll();

    Optional<Customer> findByEmail(String email);

}

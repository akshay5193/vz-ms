package com.akshay.msdemo.salesservice.repository;

import com.akshay.msdemo.salesservice.model.SalesOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalesOrderRepository extends CrudRepository<SalesOrder, Long> {

    List<SalesOrder> findAll();

    List<SalesOrder> findByCustomerEmail(String email);

}

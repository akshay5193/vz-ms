package com.akshay.msdemo.salesservice.repository;

import com.akshay.msdemo.salesservice.model.SalesOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesOrderRepository extends CrudRepository<SalesOrder, Long> {

    List<SalesOrder> findAll();

}

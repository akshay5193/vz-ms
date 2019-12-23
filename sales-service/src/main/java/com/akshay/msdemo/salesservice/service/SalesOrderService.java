package com.akshay.msdemo.salesservice.service;

import com.akshay.msdemo.salesservice.model.SalesOrder;
import com.akshay.msdemo.salesservice.repository.SalesOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class SalesOrderService {

    private SalesOrderRepository salesOrderRepository;

    public SalesOrder addNewOrder(SalesOrder order){
        return salesOrderRepository.save(order);
    }

}

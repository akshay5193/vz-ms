package com.akshay.msdemo.salesservice.service;

import com.akshay.msdemo.salesservice.model.SalesOrder;
import com.akshay.msdemo.salesservice.repository.SalesOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesOrderService {

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    public SalesOrder addNewOrder(SalesOrder order){
        System.out.println("reached the service and the order is: " + order.getDescription());
        SalesOrder newOrder = salesOrderRepository.save(order);
        System.out.println(newOrder.getCustomerEmail());
        System.out.println(newOrder.getDescription());
        return newOrder;
    }

}

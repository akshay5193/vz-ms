package com.akshay.msdemo.salesservice.service;

import com.akshay.msdemo.salesservice.model.SalesOrder;
import com.akshay.msdemo.salesservice.repository.SalesOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class SalesOrderService {

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    public SalesOrder addNewOrder(SalesOrder order){
        System.out.println("reached the service and the order is: " + order.getDescription());
        SalesOrder newOrder = salesOrderRepository.save(order);
        return newOrder;
    }

    public List<SalesOrder> findOrdersByEmail (String email) {
        List<SalesOrder> matchingOrders = salesOrderRepository.findByCustomerEmail(email);
        if (matchingOrders != null) {
            return matchingOrders;
        }else {
            System.out.println("No orders found with email '" + email + "'");
            return null;
        }
    }

}

package com.akshay.msdemo.salesservice.controller;

import com.akshay.msdemo.salesservice.CustomerServiceProxy;
import com.akshay.msdemo.salesservice.model.SalesOrder;
import com.akshay.msdemo.salesservice.service.SalesOrderService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/sales-order")
public class SalesOrderController {

    private SalesOrderService salesOrderService;

    private CustomerServiceProxy customerServiceProxy;

//    @PostMapping("/")
//    public SalesOrder createOrder(@PathVariable("customerEmail") String customerEmail,
//                                  @PathVariable("items") Long [] items,
//                                  @Valid @ModelAttribute ("salesOrder") SalesOrder salesOrder,
//                                  BindingResult result){
//        if(result.hasErrors()){
//            System.out.println("oh, there are some errors in the order input...");
//            return null;
//        }
//        else {
//            SalesOrder response = customerServiceProxy.getCustomerByEMail(customerEmail);
//            return salesOrderService.addNewOrder(salesOrder);
//        }
//    }

    @PostMapping("/")
    public SalesOrder createOrder(@RequestParam(value = "description") String description,
                                  @RequestParam(value = "email") String email
//                                  ,@RequestParam(value = "itemsList") String [] itemsList
    ) {
        System.out.println("reached here");
        SalesOrder response = customerServiceProxy.getCustomerByEMail(email);
        System.out.println(response);

        return response;
    }

}

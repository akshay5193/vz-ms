package com.akshay.msdemo.salesservice.controller;

import com.akshay.msdemo.salesservice.model.Customer;
import com.akshay.msdemo.salesservice.service.CustomerServiceProxy;
import com.akshay.msdemo.salesservice.model.SalesOrder;
import com.akshay.msdemo.salesservice.service.ItemProxy;
import com.akshay.msdemo.salesservice.service.SalesOrderService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales-order")
public class SalesOrderController {

    @Autowired
    private SalesOrderService salesOrderService;

    @Autowired
    private CustomerServiceProxy customerServiceProxy;

    @Autowired
    private ItemProxy itemProxy;

    @GetMapping("/test-url")
    public String testingConnections(){
        System.out.println("hi there... connection successful!!!");
        return "Hi there!!!";
    }

//    @PostMapping("/")
//    public SalesOrder createOrder(@RequestParam(value = "description") String description,
//                                  @RequestParam(value = "customerEmail") String customerEmail
//                                  ,@RequestParam(value = "itemsList") List<String> itemsList) {
//
////        System.out.println("received all these customers from core service: " + customerServiceProxy.getAllCustomers());
//
//        Boolean flag = true;
//        SalesOrder response = customerServiceProxy.getCustomerByEmail(customerEmail);
//        if (customerServiceProxy.getCustomerByEmail(customerEmail) != null) {
//            System.out.println("email matched...");
//
//            for(String item:itemsList){
//                if (itemProxy.findItemByName(item) != null ) {
//                    continue;
//                }
//                else {
//                    flag=false;
//                    System.out.println("'" + item + "' was not found in the items list");
//                }
//            }
//
//            if (flag == true){
//                response.setCustomerEmail(customerEmail);
//                response.setDescription(description);
//                response.setItemsList(itemsList);
//                System.out.println("-------------------------------------------");
//                System.out.println("SALES ORDER CREATED");
//                System.out.println(response.getId());
//                System.out.println(response.getCustomerEmail());
//                System.out.println(response.getDescription());
//                System.out.println(response.getItemsList());
//                System.out.println(response.getCreateAt());
//                System.out.println("-------------------------------------------");
//                return response;
//            }
//            else {
//                System.out.println("Some items in your list are not present in our store yet...");
//                return null;
//            }
//
//        }
//        else {
//            System.out.println("Hey '" + customerEmail + "' you aren't registered yet! Please register...");
//            return null;
//        }
//    }

    @PostMapping("/")
    public SalesOrder createOrder(@RequestBody SalesOrder orderData) {

        Boolean flag = true;

        Customer customerEmailResponse = customerServiceProxy.getCustomerByEmail(orderData.getCustomerEmail());

        List<String> itemNames = orderData.getItemsList();

        if (customerEmailResponse != null) {
            System.out.println("email matched...");

            for(String item: itemNames){
                if (itemProxy.findItemByName(item) != null ) {
                    continue;
                }
                else {
                    flag=false;
                    System.out.println("'" + item + "' was not found in the items list");
                }
            }

            if (flag == true) {
                // send the orderData to service and persist the object
                System.out.println("flag = true , so everything looks good and now attempting to create the order");
                return salesOrderService.addNewOrder(orderData);
            }
            else {
                // send message saying items currently not available in the store...
                System.out.println("Few items in your order are currently not available in the store...");
                return null;
            }
        }
        System.out.println("Customer with the provided email is not registered yet... [tracked in sales-order while placing the order!");
        return null;
    }

}

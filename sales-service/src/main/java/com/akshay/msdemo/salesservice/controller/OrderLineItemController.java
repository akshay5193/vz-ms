package com.akshay.msdemo.salesservice.controller;

import com.akshay.msdemo.salesservice.service.OrderLineItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-line-item")
public class OrderLineItemController {

    private OrderLineItemService orderLineItemService;

}

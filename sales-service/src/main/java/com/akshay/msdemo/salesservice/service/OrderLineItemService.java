package com.akshay.msdemo.salesservice.service;

import com.akshay.msdemo.salesservice.model.Item;
import com.akshay.msdemo.salesservice.repository.OrderLineItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineItemService {

    private OrderLineItemRepository orderLineItemRepository;

    public List<Item> addItemsToOrder(String itemName) {
        return null;
    }

}

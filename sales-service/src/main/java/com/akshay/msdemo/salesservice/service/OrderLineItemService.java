package com.akshay.msdemo.salesservice.service;

import com.akshay.msdemo.salesservice.model.Item;
import com.akshay.msdemo.salesservice.model.OrderLineItem;
import com.akshay.msdemo.salesservice.repository.OrderLineItemRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderLineItemService {

    @Autowired
    private OrderLineItemRepository orderLineItemRepository;

    @Autowired
    private ItemProxy itemProxy;

//    public List<Item> getAllItems() {
//        return orderLineItemRepository
//    }

    public void addItemsToOrder(List<String> itemNames, Long orderId) {
        System.out.println("going through the list of items and adding them to order line item table...");
        for (String item : itemNames) {

            OrderLineItem itemToCount = orderLineItemRepository.findByItemNameAndOrderId(item, orderId);
            System.out.println("working on '" + item + "'");

            if (itemToCount != null && itemToCount.getOrderId() == orderId){
                System.out.println("this item was already in the cart...");
                continue;
            }

            System.out.println("this is the unique product in the list...");

            OrderLineItem itemToPersist = new OrderLineItem();

            itemToPersist.setItemName(item);
            itemToPersist.setOrderId(orderId);
            itemToPersist.setQuantity(Collections.frequency(itemNames, item));
            System.out.println(itemToPersist.getQuantity() + "quantity of '" + item + "'" );

            OrderLineItem newEntry = orderLineItemRepository.save(itemToPersist);
            System.out.println(newEntry.getItemName());
            System.out.println(newEntry.getQuantity());

        }
    }

    public List<OrderLineItem> getOrderLineItemsByOrderId(Long orderId) {
        List<OrderLineItem> orderItems = orderLineItemRepository.findByOrderId(orderId);
        return orderItems;
    }

}

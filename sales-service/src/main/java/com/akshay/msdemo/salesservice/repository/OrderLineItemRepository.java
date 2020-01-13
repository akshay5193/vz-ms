package com.akshay.msdemo.salesservice.repository;

import com.akshay.msdemo.salesservice.model.OrderLineItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineItemRepository extends CrudRepository<OrderLineItem, Long> {

    List<OrderLineItem> findAll();

    OrderLineItem findByItemNameAndOrderId(String name, Long orderId);

    List<OrderLineItem> findByOrderId(Long orderId);

}

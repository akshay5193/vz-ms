package com.akshay.msdemo.salesservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order_items")
public class OrderLineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long itemId;

//    private Long quantity;

    private Long orderId;

}

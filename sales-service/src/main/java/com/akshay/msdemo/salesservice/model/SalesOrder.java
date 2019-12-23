package com.akshay.msdemo.salesservice.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sales-order")
public class SalesOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=2, max=300)
    private String description;

    @DecimalMin("0.1")
    private Double price;

//    -----------------------------------------------------------

    private Long customerId;
    @ElementCollection
    List<String> itemsList = new ArrayList<String>();

//    @ElementCollection
//    private List<Long> itemIds = new ArrayList<>();

//    -----------------------------------------------------------

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    public SalesOrder() {
    }

    public SalesOrder(String description, Double price, String email) {
    }
}

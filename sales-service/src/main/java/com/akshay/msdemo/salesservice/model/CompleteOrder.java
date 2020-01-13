package com.akshay.msdemo.salesservice.model;

import java.util.Date;
import java.util.List;

public class CompleteOrder {

    private Date date;
    private String customerEmail;
    private String description;
    private double orderPrice;
    private List<String> itemNames;


    public CompleteOrder() {
        date = new Date();
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public List<String> getItemNames() {
        return itemNames;
    }

    public void setItemNames(List<String> itemNames) {
        this.itemNames = itemNames;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InputOrder{");
        sb.append("date=").append(date);
        sb.append(", email_id='").append(customerEmail).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", price=").append(orderPrice);
        sb.append(", itemNames=").append(itemNames);
        sb.append('}');
        return sb.toString();
    }
}



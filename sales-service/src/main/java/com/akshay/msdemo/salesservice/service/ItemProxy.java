package com.akshay.msdemo.salesservice.service;

import com.akshay.msdemo.salesservice.model.Item;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

//@FeignClient(name="item", url="localhost:9000")
//@FeignClient(name="item")       // you do not need the url while using the Ribbon load balancing
@FeignClient(name="zuul-api-gateway-server")    // to make requests go through the ZUUL API GATEWAY
@RibbonClient(name = "item")
public interface ItemProxy {

    @GetMapping("/item/api/items/{name}")
    public Item findItemByName(@PathVariable("name") String name);

    @GetMapping("/fault-tolerance-example")
    public Item retrieveConfiguration();

//    @PostMapping("items/add")
//    public  Item addNewItem(@Valid @ModelAttribute("items") Item item, BindingResult result);

}

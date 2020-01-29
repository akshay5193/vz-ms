package com.akshay.msdemo.item.controller;

import com.akshay.msdemo.item.model.Item;
import com.akshay.msdemo.item.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private Environment environment;

    @GetMapping("/")
    public List<Item> getAllItems() {
        System.out.println("Getting all items");
        String serverPort = environment.getProperty("local.server.port");
        System.out.println("Port: " + serverPort);
        return itemService.getAllItems();
    }

    @PostMapping("/")
    public  Item addNewItem(@Valid @ModelAttribute("items") Item item, BindingResult result){
        if (result.hasErrors()) {
            return  null;
        }
        System.out.println("Creating a new item...");
        String serverPort = environment.getProperty("local.server.port");
        System.out.println("Port: " + serverPort);
        return itemService.addItem(item);
    }

    @Cacheable(value = "item-name", key = "#itemName")
    @GetMapping("/{itemName}")
//    @HystrixCommand(fallbackMethod = )
    public Item findItemByName(@PathVariable("itemName") String itemName) {
        System.out.println("api call");
        Item itemWithName = itemService.getItemByName(itemName);
        String serverPort = environment.getProperty("local.server.port");
        System.out.println("Port: " + serverPort);
        return  itemWithName;
    }

    @GetMapping("/fault-tolerance-example")
    @HystrixCommand(fallbackMethod="fallbackRetrieveConfiguration")
    public Item retrieveConfiguration() {
        throw new RuntimeException("Not available");
    }

    public Item fallbackRetrieveConfiguration() {
        Item dummyItem = new Item("dummy name","dummy description", 999.99);
        return dummyItem;
    }

}

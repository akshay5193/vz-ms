package com.akshay.msdemo.item.controller;

import com.akshay.msdemo.item.model.Item;
import com.akshay.msdemo.item.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public List<Item> getAllItems() {
        System.out.println("Getting all items");
        return itemService.getAllItems();
    }

    @PostMapping("/")
    public  Item addNewItem(@Valid @ModelAttribute("items") Item item, BindingResult result){
        if (result.hasErrors()) {
            return  null;
        }
        System.out.println("Creating a new item...");
        return itemService.addItem(item);
    }

    @GetMapping("/{name}")
//    @HystrixCommand(fallbackMethod = )
    public Item findItemByName(@PathVariable("name") String name) {
        Item itemWithName = itemService.getItemByName(name);
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

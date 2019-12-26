package com.akshay.msdemo.item.controller;

import com.akshay.msdemo.item.model.Item;
import com.akshay.msdemo.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("items")
    public List<Item> getAllItems() {
        System.out.println("Getting all items");
        return itemService.getAllItems();
    }

    @PostMapping("items/add")
    public  Item addNewItem(@Valid @ModelAttribute("items") Item item, BindingResult result){
        if (result.hasErrors()) {
            return  null;
        }
        System.out.println("Creating a new item...");
        return itemService.addItem(item);
    }

    @GetMapping("items/{name}")
    public Item findItemByName(@PathVariable("name") String name) {
        Item itemWithName = itemService.getItemByName(name);
        return  itemWithName;
    }

//    @GetMapping("/items/{itemsList}")
//    public List<Item> getItemsByList(@PathVariable("itemsList") List<String> itemsList) {
//        return itemService.findByNamesList(itemsList);
//    }

}

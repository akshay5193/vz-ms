package com.akshay.msdemo.item.repository;

import com.akshay.msdemo.item.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    List<Item> findAll();
    Optional<Item> findByName(String name);

}

package com.infoshareacademy.javadabadoo.controller;

import com.infoshareacademy.javadabadoo.model.Item;
import com.infoshareacademy.javadabadoo.model.ItemRepo2;
import com.infoshareacademy.javadabadoo.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
@AllArgsConstructor
public class ItemController {

    private final ItemRepo2 itemRepo2;
    private final ItemService itemService;

    @PostMapping()
    public void saveBook(@RequestBody Object article) {
        var toSave = new Item();
        itemRepo2.save(toSave);
    }
    @GetMapping
    public List<Item> getItems() {
        return itemRepo2.findAll();
    }

    @GetMapping("/all")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemRepo2.deleteById(id);
    }

}

package com.example.marketplace.controller;

import com.example.marketplace.entity.Item;
import com.example.marketplace.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable Long itemId, @RequestParam Long sellerId) {
        itemService.deleteItem(itemId, sellerId);
    }

    @PutMapping("/{itemId}")
    public Item updateItem(@PathVariable Long itemId, @RequestBody Item item) {
        item.setId(itemId);
        return itemService.updateItem(item);
    }

    @PutMapping("/{itemId}/sold")
    public Item markAsSold(@PathVariable Long itemId, @RequestParam Long sellerId) {
        return itemService.markAsSold(itemId, sellerId);
    }

    @GetMapping
    public List<Item> getItemsByCategory(@RequestParam String category) {
        return itemService.getItemsByCategory(category);
    }
}

package com.saintjulienbeychevelle.market.controller;

import com.saintjulienbeychevelle.market.entity.Item;
import com.saintjulienbeychevelle.market.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/seller/{sellerId}")
    public List<Item> getItemsBySeller(@PathVariable Long sellerId) {
        return itemService.getItemsBySeller(sellerId);
    }

    @PostMapping
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @DeleteMapping("/{itemId}/seller/{sellerId}")
    public void deleteItem(@PathVariable Long itemId, @PathVariable Long sellerId) {
        itemService.deleteItem(itemId, sellerId);
    }

    @PutMapping("/{itemId}/seller/{sellerId}")
    public Item updateItem(@PathVariable Long itemId, @RequestBody Item item, @PathVariable Long sellerId) {
        return itemService.updateItem(item, sellerId);
    }

    @PutMapping("/{itemId}/sold/seller/{sellerId}")
    public Item markItemAsSold(@PathVariable Long itemId, @PathVariable Long sellerId) {
        return itemService.markItemAsSold(itemId, sellerId);
    }
}

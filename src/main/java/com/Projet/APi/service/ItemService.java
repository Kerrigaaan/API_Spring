package com.example.marketplace.service;

import com.example.marketplace.entity.Item;
import com.example.marketplace.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public void deleteItem(Long itemId, Long sellerId) {
        Item item = itemRepository.findById(itemId).orElseThrow();
        if (!item.getSeller().getId().equals(sellerId)) {
            throw new RuntimeException("Unauthorized");
        }
        itemRepository.delete(item);
    }

    public Item updateItem(Item item) {
        return itemRepository.save(item);
    }

    public Item markAsSold(Long itemId, Long sellerId) {
        Item item = itemRepository.findById(itemId).orElseThrow();
        if (!item.getSeller().getId().equals(sellerId)) {
            throw new RuntimeException("Unauthorized");
        }
        item.setSold(true);
        return itemRepository.save(item);
    }

    public List<Item> getItemsByCategory(String category) {
        return itemRepository.findByCategoryAndIsSoldFalse(category);
    }
}

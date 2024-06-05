package com.saintjulienbeychevelle.market.service;

import com.saintjulienbeychevelle.market.entity.Item;
import com.saintjulienbeychevelle.market.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findBySoldFalse();
    }

    public List<Item> getItemsBySeller(Long sellerId) {
        return itemRepository.findBySellerIdAndSoldFalse(sellerId);
    }

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public void deleteItem(Long itemId, Long sellerId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        if (!item.getSeller().getId().equals(sellerId)) {
            throw new RuntimeException("Unauthorized");
        }
        itemRepository.delete(item);
    }

    public Item updateItem(Item item, Long sellerId) {
        if (!item.getSeller().getId().equals(sellerId)) {
            throw new RuntimeException("Unauthorized");
        }
        return itemRepository.save(item);
    }

    public Item markItemAsSold(Long itemId, Long sellerId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        if (!item.getSeller().getId().equals(sellerId)) {
            throw new RuntimeException("Unauthorized");
        }
        item.setSold(true);
        return itemRepository.save(item);
    }
}


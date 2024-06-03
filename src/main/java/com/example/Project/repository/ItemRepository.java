package com.example.marketplace.repository;

import com.example.marketplace.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByCategoryAndIsSoldFalse(String category);
    List<Item> findBySellerId(Long sellerId);
}

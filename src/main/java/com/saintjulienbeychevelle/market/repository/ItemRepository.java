package com.saintjulienbeychevelle.market.repository;

import com.saintjulienbeychevelle.market.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findBySoldFalse();
    List<Item> findBySellerIdAndSoldFalse(Long sellerId);
}

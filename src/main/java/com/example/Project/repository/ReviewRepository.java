package com.example.marketplace.repository;

import com.example.marketplace.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByItemId(Long itemId);
}

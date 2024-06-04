package com.example.Project.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;
    private String category;
    private boolean isSold;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

}

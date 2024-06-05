package com.saintjulienbeychevelle.market.entity;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;
    private boolean sold = false;

    @ManyToOne
    private User seller;

}

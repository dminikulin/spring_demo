package com.example.spring_demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "listings")
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "headphone_id")
    private Long headphone_id;

    private float price;

    public Listing() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHeadphone_id() {
        return headphone_id;
    }

    public void setHeadphone_id(Long headphoneId) {
        this.headphone_id = headphoneId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

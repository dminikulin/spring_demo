package com.example.spring_demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "listings")
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "headphone_id")
    private Headphone headphone;

    private float price;

    public Listing() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Headphone getHeadphone() {
        return headphone;
    }

    public void setHeadphone(Headphone headphone) {
        this.headphone = headphone;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

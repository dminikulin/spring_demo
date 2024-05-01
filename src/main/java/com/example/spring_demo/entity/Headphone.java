package com.example.spring_demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="headphones")
public class Headphone {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "brand")
    private Brand brand;
    private String name;
    @ManyToOne
    @JoinColumn(name = "type")
    private Type type;
    @ManyToOne
    @JoinColumn(name = "connection")
    private Connection connection;

    public Headphone(Long id, Brand brand, String name, Type type, Connection connection) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.type = type;
        this.connection = connection;
    }

    public Headphone() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}

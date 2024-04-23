package com.example.spring_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Connection {
    @Id
    private Long id;
    private String connection;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }
}

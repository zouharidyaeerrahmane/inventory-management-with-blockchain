package com.app.inventoryblockchain.presentation.models;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Transaction {
    private long id;
    private Type type;
    private LocalDate date;
    private Product product;
    private int quantity;
    private String hash;
    private String previousHash;
    private Timestamp timestamp;
    private User user;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Transaction() {}

    public Transaction(long id, Type type, LocalDate date, Product product, int quantity, User user) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.product = product;
        this.quantity = quantity;
        this.user = user;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

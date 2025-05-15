package com.app.inventoryblockchain.presentation.models;

import java.sql.Timestamp;
import java.time.LocalDate;

public final class Transaction {
    private final long id;
    private final Type type;
    private final LocalDate date;
    private final Product product;
    private final int quantity;
    private final String previousHash;
    private final String hash;
    private final Timestamp timestamp;
    private final User user;

    public Transaction(long id, Type type, LocalDate date, Product product, int quantity,
                       String previousHash, String hash, Timestamp timestamp, User user) {
        this.id = 0;
        this.type = type;
        this.date = date;
        this.product = product;
        this.quantity = quantity;
        this.previousHash = previousHash;
        this.hash = hash;
        this.timestamp = timestamp;
        this.user = user;
    }

    // Getters only
    public long getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public User getUser() {
        return user;
    }


    public boolean isValidHash(String computedHash) {
        return this.hash.equals(computedHash);
    }
}

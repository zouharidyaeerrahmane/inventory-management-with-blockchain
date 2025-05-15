package com.app.inventoryblockchain.presentation.models;

public class Product {
    private long id;
    private String name;
    private int quantity;
    private int threshold;
    private double price;

    public Product() {

    }

    public Product(long id, double price, int threshold, int quantity, String name) {
        this.id = id;
        this.price = price;
        this.threshold = threshold;
        this.quantity = quantity;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
} 
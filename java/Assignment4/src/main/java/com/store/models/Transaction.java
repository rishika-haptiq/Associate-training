package com.store.models;

import java.sql.Timestamp;

public class Transaction {
    private int id;
    private int productId;
    private int quantity;
    private String type; // "SALE" or "RESTOCK"
    private Timestamp timestamp;

    public Transaction() {}

    public Transaction(int id, int productId, int quantity, String type, Timestamp timestamp) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.type = type;
        this.timestamp = timestamp;
    }

    // Getters and setters...
    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return id + ". " + type + " - Product ID: " + productId + " | Qty: " + quantity + " | Time: " + timestamp;
    }
}

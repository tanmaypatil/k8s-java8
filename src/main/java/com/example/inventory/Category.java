package com.example.inventory;

public enum Category {
    ELECTRONICS(0.18),
    GROCERY(0.05),
    BOOKS(0.0);

    private final double taxRate;

    Category(double taxRate) { this.taxRate = taxRate; }

    public double getTaxRate() { return taxRate; }
}

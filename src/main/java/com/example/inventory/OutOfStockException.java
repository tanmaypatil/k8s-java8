package com.example.inventory;

public class OutOfStockException extends RuntimeException {
    public OutOfStockException(String sku, int requested, int available) {
        super("Out of stock: " + sku + " requested=" + requested + " available=" + available);
    }
}

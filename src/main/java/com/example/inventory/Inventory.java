package com.example.inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/** Tracks stock levels per product. */
public class Inventory {
    private final Map<String, Product> products = new HashMap<String, Product>();
    private final Map<String, Integer> stock = new HashMap<String, Integer>();

    public void receive(Product product, int quantity) {
        products.put(product.getSku(), product);
        Integer current = stock.get(product.getSku());
        stock.put(product.getSku(), (current == null ? 0 : current) + quantity);
    }

    public int available(String sku) {
        Integer current = stock.get(sku);
        return current == null ? 0 : current;
    }

    public Optional<Product> find(String sku) {
        return Optional.ofNullable(products.get(sku));
    }

    /** Removes stock for every line of the order, or nothing if any line is short. */
    public void fulfil(Order order) {
        for (OrderLine line : order.getLines()) {
            String sku = line.getProduct().getSku();
            if (available(sku) < line.getQuantity()) {
                throw new OutOfStockException(sku, line.getQuantity(), available(sku));
            }
        }
        for (OrderLine line : order.getLines()) {
            String sku = line.getProduct().getSku();
            stock.put(sku, available(sku) - line.getQuantity());
        }
    }
}

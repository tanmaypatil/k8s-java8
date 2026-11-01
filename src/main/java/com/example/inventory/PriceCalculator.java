package com.example.inventory;

/** Computes order totals including per-category tax and a bulk discount. */
public class PriceCalculator {
    static final int BULK_THRESHOLD = 10;
    static final double BULK_DISCOUNT = 0.10;

    public double total(Order order) {
        double total = 0;
        for (OrderLine line : order.getLines()) {
            double subtotal = line.subtotal();
            if (line.getQuantity() >= BULK_THRESHOLD) {
                subtotal = subtotal * (1 - BULK_DISCOUNT);
            }
            total += subtotal * (1 + line.getProduct().getCategory().getTaxRate());
        }
        return Math.round(total * 100.0) / 100.0;
    }
}

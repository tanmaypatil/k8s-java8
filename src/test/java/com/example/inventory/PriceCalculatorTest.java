package com.example.inventory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PriceCalculatorTest {
    @Test
    public void appliesTaxAndBulkDiscount() {
        Product rice = new Product("R", "Rice", Category.GROCERY, 10.0);
        // 10 units -> 100, 10% bulk discount -> 90, 5% tax -> 94.5
        assertEquals(94.5, new PriceCalculator().total(new Order("o").add(rice, 10)), 0.001);
    }

    @Test
    public void noDiscountBelowThreshold() {
        Product tv = new Product("T", "TV", Category.ELECTRONICS, 100.0);
        assertEquals(118.0, new PriceCalculator().total(new Order("o").add(tv, 1)), 0.001);
    }
}

package com.example.inventory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InventoryTest {
    private final Product pen = new Product("P", "Pen", Category.BOOKS, 1.0);

    @Test
    public void fulfilReducesStock() {
        Inventory inv = new Inventory();
        inv.receive(pen, 10);
        inv.fulfil(new Order("o").add(pen, 4));
        assertEquals(6, inv.available("P"));
    }

    @Test(expected = OutOfStockException.class)
    public void fulfilFailsWhenShort() {
        Inventory inv = new Inventory();
        inv.receive(pen, 1);
        inv.fulfil(new Order("o").add(pen, 2));
    }
}

package com.example.inventory;

/** An item that can be stocked and sold. Plain Java 8 value class. */
public final class Product {
    private final String sku;
    private final String name;
    private final Category category;
    private final double unitPrice;

    public Product(String sku, String name, Category category, double unitPrice) {
        if (unitPrice < 0) {
            throw new IllegalArgumentException("unitPrice must be >= 0");
        }
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.unitPrice = unitPrice;
    }

    public String getSku() { return sku; }
    public String getName() { return name; }
    public Category getCategory() { return category; }
    public double getUnitPrice() { return unitPrice; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        return sku.equals(((Product) o).sku);
    }

    @Override
    public int hashCode() { return sku.hashCode(); }

    @Override
    public String toString() { return name + " (" + sku + ")"; }
}

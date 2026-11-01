package com.example.inventory;

public class App {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Product laptop = new Product("SKU-1", "Laptop", Category.ELECTRONICS, 900.0);
        Product rice = new Product("SKU-2", "Rice 5kg", Category.GROCERY, 12.5);
        Product book = new Product("SKU-3", "Kubernetes Book", Category.BOOKS, 40.0);
        inventory.receive(laptop, 5);
        inventory.receive(rice, 100);
        inventory.receive(book, 20);

        Order order = new Order("ORD-1001").add(laptop, 1).add(rice, 12).add(book, 2);
        inventory.fulfil(order);

        System.out.println(new ReportPrinter(new PriceCalculator()).print(order));
        System.out.println("Running on Java " + System.getProperty("java.version"));
    }
}

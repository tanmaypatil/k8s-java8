package com.example.inventory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Order {
    private final String id;
    private final List<OrderLine> lines = new ArrayList<OrderLine>();

    public Order(String id) { this.id = id; }

    public Order add(Product product, int quantity) {
        lines.add(new OrderLine(product, quantity));
        return this;
    }

    public String getId() { return id; }

    public List<OrderLine> getLines() { return Collections.unmodifiableList(lines); }
}

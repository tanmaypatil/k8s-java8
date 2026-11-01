package com.example.inventory;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/** Builds a plain-text summary of an order using Java 8 streams. */
public class ReportPrinter {
    private final PriceCalculator calculator;

    public ReportPrinter(PriceCalculator calculator) { this.calculator = calculator; }

    public String print(Order order) {
        Map<Category, Integer> unitsByCategory = order.getLines().stream()
            .collect(Collectors.groupingBy(l -> l.getProduct().getCategory(),
                     TreeMap::new, Collectors.summingInt(OrderLine::getQuantity)));

        StringBuilder sb = new StringBuilder();
        sb.append("Order ").append(order.getId()).append('\n');
        for (Map.Entry<Category, Integer> e : unitsByCategory.entrySet()) {
            sb.append("  ").append(e.getKey()).append(": ").append(e.getValue()).append(" units\n");
        }
        sb.append("  Total: ").append(String.format("%.2f", calculator.total(order)));
        return sb.toString();
    }
}

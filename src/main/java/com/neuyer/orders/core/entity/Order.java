package com.neuyer.orders.core.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Order {
    final private String id;
    final private String userId;
    private List<Product> items;
    private BigDecimal total;

    public Order(String userId, String id) {
        this.userId = userId;
        this.id = id;
    }

    private Order(String id, String userId, List<Product> items) {
        this.id = id;
        this.userId = userId;
        this.items = items;
        calculateTotal();
    }

    public static Order from(String id, String userId, List<Product> items) {
        if (id == null || id.isBlank())
            throw new IllegalArgumentException("id cannot be null or blank");
        if (userId == null || userId.isBlank())
            throw new IllegalArgumentException("userId cannot be null or blank");
        if (items == null || id.isEmpty())
            throw new IllegalArgumentException("items cannot be null or empty");

        return new Order(id, userId, items);
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    private void calculateTotal() {
        var res = BigDecimal.ZERO;
        this.items.forEach(product -> res.add(product.calculateTotal()));
        this.total = res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(userId, order.userId) && Objects.equals(items, order.items) && Objects.equals(total, order.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, items, total);
    }
}

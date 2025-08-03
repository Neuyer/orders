package com.neuyer.orders.core.entity;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public final class Product {

    private final String id;
    private String sku;
    private Integer quantity;
    private BigDecimal price;

    private Product(String id, String sku, Integer quantity, BigDecimal price) {
        this.id = id;
        this.sku = sku;
        this.quantity = quantity;
        this.price = price;
    }

    public static Product create(String sku, Integer quantity, BigDecimal price) {
        // Enforce invariants on creation
        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("SKU cannot be null or blank");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be null or negative");
        }
        return new Product(UUID.randomUUID().toString(), sku, quantity, price);
    }

    public static Product from(String id, String sku, Integer quantity, BigDecimal price) {
        // Enforce invariants on creation
        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("SKU cannot be null or blank");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be null or negative");
        }
        return new Product(id, sku, quantity, price);
    }

    public BigDecimal calculateTotal() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    public String getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    // Business behaviors
    public void changePrice(BigDecimal newPrice) {
        if (newPrice == null || newPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be null or negative");
        }
        this.price = newPrice;
    }

    public void addStock(Integer amount) {
        if (amount == null || amount < 0) {
            throw new IllegalArgumentException("Amount to add cannot be null or negative");
        }
        this.quantity += amount;
    }

    public void removeStock(Integer amount) {
        if (amount == null || amount < 0) {
            throw new IllegalArgumentException("Amount to remove cannot be null or negative");
        }
        if (this.quantity < amount) {
            throw new IllegalStateException("Cannot remove more stock than available");
        }
        this.quantity -= amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", sku='" + sku + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

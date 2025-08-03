package com.neuyer.orders.core.entity;
import java.util.Objects;
import java.util.UUID;

public final class User {

    private final String id;
    private String name;

    private User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static User create(String name) {
        return new User(UUID.randomUUID().toString(), name);
    }

    public static User from(String id, String name) {
        return new User(id, name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void changeName(String newName) {
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = newName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

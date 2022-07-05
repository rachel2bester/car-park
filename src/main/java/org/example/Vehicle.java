package org.example;

public class Vehicle {
    private String type;
    private String id;

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public Vehicle(String type, String id) {
        this.type = type;
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}

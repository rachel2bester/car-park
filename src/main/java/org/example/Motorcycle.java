package org.example;

public class Motorcycle extends Vehicle{
    private static int motorcycleCount;

    public Motorcycle() {
        super("motorcycle", "motorcycle-" + motorcycleCount);
        motorcycleCount++;
    }
}

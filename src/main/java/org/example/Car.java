package org.example;

public class Car extends Vehicle{
    private static int carCount;

    public Car() {
        super("car", "car-" + carCount);
        carCount++;
    }
}

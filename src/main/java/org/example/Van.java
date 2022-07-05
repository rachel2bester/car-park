package org.example;

public class Van extends Vehicle {
    private static int vanCount;

    public Van() {
        super("van", "van-" + vanCount);
        vanCount++;
    }
}

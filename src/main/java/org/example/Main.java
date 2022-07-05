package org.example;

public class Main {
    public static void main(String[] args) {
        CarPark carPark = new CarPark(9, 16, 8, 10, 1);
        carPark.displayVehicles();
        carPark.displaySpots();
        carPark.removeVehicle("car-0");
        carPark.removeVehicle("car-1");
        carPark.removeVehicle("car-2");
        carPark.displaySpots();
        carPark.newVehicle("car");
        carPark.newVehicle("van");
        carPark.displaySpots();
    }
}
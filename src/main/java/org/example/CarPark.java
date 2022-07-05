package org.example;

import java.util.Arrays;
import java.util.HashSet;

public class CarPark {
    private Vehicle[] motorcycleSpots;
    private Vehicle[] regSpots;

    public CarPark(int numOfMotorcycleSpots, int numOfRegSpots, int motorcycles, int cars, int vans) {
        this.motorcycleSpots = new Vehicle[numOfMotorcycleSpots];
        this.regSpots = new Vehicle[numOfRegSpots];

        for (int i = 0; i < motorcycleSpots.length && i < motorcycles; i++) {
            motorcycleSpots[i] = new Motorcycle();
        }
        try {
            for (int i = 0; i < vans; i++) {
                Vehicle newVan = new Van();
                int index = i * 3;
                for (int j = index; j < index + 3; j++) {
                    regSpots[j] = newVan;
                }
            }

            int nextSpot = vans * 3;
            for (int i = nextSpot; i < cars + nextSpot; i++) {
                regSpots[i] = new Car();
            }

            nextSpot = vans * 3 + cars;
            int remainingMotorcycles = motorcycles - numOfMotorcycleSpots;

            for (int i = nextSpot; i < remainingMotorcycles + nextSpot; i++) {
                regSpots[i] = new Motorcycle();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Not enough spots for the number of vehicles.");
        }
    }

    public boolean isMotorcycleSpotsEmpty() {
        for (int i = 0; i < motorcycleSpots.length; i++) {
            if (motorcycleSpots[i] != null) {
                return false;
            }
        }
        return true;
    }
    public boolean isRegSpotsEmpty() {
        for (int i = 0; i < regSpots.length; i++)
            if (regSpots[i] != null)
                return false;
        return true;
    }

    public boolean isEmpty() {
        return isMotorcycleSpotsEmpty() && isRegSpotsEmpty();
    }

    public boolean isMotorcycleSpotsFull() {
        for (int i = 0; i < motorcycleSpots.length; i++)
            if (motorcycleSpots[i] == null)
                return false;
        return true;
    }

    public boolean isRegSpotsFull() {
        for (int i = 0; i < regSpots.length; i++)
            if (regSpots[i] == null)
                return false;
        return true;
    }

    public boolean isFull() {
        return isMotorcycleSpotsFull() && isRegSpotsFull();
    }

    public void displayVehicles() {
        System.out.println("Vehicles in Motorcycle spots");
        HashSet<Vehicle> motorcycleSpotVehicles = new HashSet<>(Arrays.asList(motorcycleSpots));
        motorcycleSpotVehicles.remove(null);
        for (Vehicle vehicle: motorcycleSpotVehicles) {
            System.out.println(vehicle);
        }

        System.out.println("\nVehicles in regular spots");
        HashSet<Vehicle> regSpotVehicles = new HashSet<>(Arrays.asList(regSpots));
        regSpotVehicles.remove(null);
        for (Vehicle vehicle: regSpotVehicles) {
            System.out.println(vehicle);
        }
    }

    public int getMotorcycleSpotsRemaining() {
        int count = 0;
        for (int i = 0; i < motorcycleSpots.length; i++) {
            if (motorcycleSpots[i] == null) {
                count++;
            }
        }
        return count;
    }

    public int getRegSpotsRemaining() {
        int count = 0;
        for (int i = 0; i < regSpots.length; i++) {
            if (regSpots[i] == null) {
                count++;
            }
        }
        return count;
    }

    public int getTotalSpotsRemaining() {
        return getMotorcycleSpotsRemaining() + getRegSpotsRemaining();
    }

    public void displayInfo() {
        displayVehicles();
        System.out.println(
                "\nmotorcycle spots left: " + getMotorcycleSpotsRemaining() +
                "\nregular spots left: " + getRegSpotsRemaining() +
                "\ntotal left: " + getTotalSpotsRemaining()
        );
    }

    public void displaySpots() {
        for (int i = 0; i < motorcycleSpots.length; i++) {
            System.out.println("Motorcycle Spot " + i + ": " + motorcycleSpots[i]);
        }

        for (int i = 0; i < regSpots.length; i++) {
            System.out.println("Regular Spot " + i + ": " + regSpots[i]);
        }
    }

    public void newVehicle(String type) {

        switch (type) {
            case "car":
                for (int i = 0; i < regSpots.length; i++) {
                    if(regSpots[i] == null) {
                        regSpots[i] = new Car();
                        return;
                    }
                }
                break;

            case "motorcycle":
                for (int i = 0; i < motorcycleSpots.length; i++) {
                    if(motorcycleSpots[i] == null) {
                        motorcycleSpots[i] = new Motorcycle();
                        return;
                    }
                }
                for (int i = 0; i < regSpots.length; i++) {
                    if(regSpots[i] == null) {
                        regSpots[i] = new Motorcycle();
                        return;
                    }
                }
                break;

            case "van":
                for (int i = 0; i < regSpots.length - 2; i++) {
                    if(regSpots[i] == null && regSpots[i + 1] == null && regSpots[i + 2] == null) {
                        Vehicle newVan = new Van();
                        regSpots[i] = newVan;
                        regSpots[i + 1] = newVan;
                        regSpots[i + 2] = newVan;
                        return;
                    }
                }
                break;

            default:
                throw new IllegalArgumentException("There is no vehicle type called: " + type);
        }
        throw new IllegalArgumentException("No space for a new " + type + ".");
    }

    public void removeVehicle(String id) {
        for (int i = 0; i < motorcycleSpots.length; i++) {
            if (motorcycleSpots[i] != null && id.equals(motorcycleSpots[i].getId())) {
                motorcycleSpots[i] = null;
            }
        }
        for (int i = 0; i < regSpots.length; i++) {
            if (regSpots[i] != null && id.equals(regSpots[i].getId())) {
                regSpots[i] = null;
            }
        }
    }
}

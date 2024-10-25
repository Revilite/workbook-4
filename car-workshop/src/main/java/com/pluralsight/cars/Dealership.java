package com.pluralsight.cars;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    private final String name;
    private final String address;
    private final String phoneNumber;

    private ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //Filters the inventory by the prices range and sorts it by the lowest price
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        return inventory.stream().filter((c) -> c.getPrice() >= min && c.getPrice() <= max).sorted(Comparator.comparingDouble(Vehicle::getPrice)).toList();
    }

    //Filters by the make and model then sorts by the lowest price if there is more than 1 car with the same make model
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return inventory.stream().filter((c) -> c.getMake().equalsIgnoreCase(make) && c.getModel().equalsIgnoreCase(model)).sorted(Comparator.comparingDouble(Vehicle::getPrice)).toList();
    }

    //Filters by the year range and sorts by the highest year
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        return inventory.stream().filter((c) -> c.getYear() >= min && c.getYear() <= max).sorted(Comparator.comparingInt(Vehicle::getYear).reversed()).toList();
    }

    //Filters by the color and sorts by lowest prices with the if there is more than 1 car with the same color
    public List<Vehicle> getVehiclesByColor(String color) {
        return inventory.stream().filter((c) -> c.getColor().equalsIgnoreCase(color)).sorted(Comparator.comparingDouble(Vehicle::getPrice)).toList();
    }

    //Filters by mileage and then sorts by lowest mileage
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        return inventory.stream().filter((c) -> c.getOdometer() >= min && c.getOdometer() <= max).sorted(Comparator.comparingDouble(Vehicle::getOdometer)).toList();
    }
    //Filters by type of car then sorts by lowest prices
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        return inventory.stream().filter((c) -> c.getVehicleType().equalsIgnoreCase(vehicleType)).sorted(Comparator.comparingDouble(Vehicle::getPrice)).toList();
    }
    //Filters by list will only return a list with a size of 1
    public List<Vehicle> getVehiclesByVin(int vin) {
        return inventory.stream().filter((c) -> c.getVin() == vin).toList();
    }

    public List<Vehicle> getAllVehicles() {
        return inventory.stream().sorted(Comparator.comparingDouble(Vehicle::getPrice)).toList();
    }

    public void addVehicle(Vehicle v) {
        inventory.add(v);
    }

    public void removeVehicle(Vehicle v) {
        inventory.remove(v);
    }
}

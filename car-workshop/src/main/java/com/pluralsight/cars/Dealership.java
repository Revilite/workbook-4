package com.pluralsight.cars;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phoneNumber;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        return inventory.stream().filter((c) -> c.getPrice() >= min && c.getPrice() <= max).toList();
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        return inventory.stream().filter((c) -> c.getMake().equalsIgnoreCase(make) && c.getMake().equalsIgnoreCase(model)).toList();
    }

    public void addVehicle(Vehicle v) {
        inventory.add(v);
    }
}

package com.pluralsight.cars;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phoneNumber;

    private ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        return inventory.stream().filter((c) -> c.getPrice() >= min && c.getPrice() <= max).toList();
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        return inventory.stream().filter((c) -> c.getMake().equalsIgnoreCase(make) && c.getModel().equalsIgnoreCase(model)).toList();
    }

    public List<Vehicle> getVehiclesByYear(int min, int max){
        return inventory.stream().filter((c) -> c.getYear() >= min && c.getYear() <= max).toList();
    }

    public List<Vehicle> getVehiclesByColor(String color){
        return inventory.stream().filter((c) -> c.getColor().equalsIgnoreCase(color)).toList();
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max){
        return inventory.stream().filter((c) -> c.getOdometer() >= min && c.getOdometer() <= max).toList();
    }

    public List<Vehicle> getVehiclesByType(String vehicleType){
        return inventory.stream().filter((c) -> c.getVehicleType().equalsIgnoreCase(vehicleType)).toList();
    }

    public void addVehicle(Vehicle v) {
        inventory.add(v);
    }

    public void removeVehicle(Vehicle v){
        inventory.remove(v);
    }


    @Override
    public String toString() {
        return name + " | " + address + " | " + phoneNumber;
    }
}

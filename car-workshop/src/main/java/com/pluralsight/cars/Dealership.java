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

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        return inventory.stream().filter((c) -> c.getPrice() >= min && c.getPrice() <= max).sorted(Comparator.comparingDouble(Vehicle::getPrice)).toList();
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        return inventory.stream().filter((c) -> c.getMake().equalsIgnoreCase(make) && c.getModel().equalsIgnoreCase(model)).sorted(Comparator.comparingDouble(Vehicle::getPrice)).toList();
}

    public List<Vehicle> getVehiclesByYear(int min, int max){
        return inventory.stream().filter((c) -> c.getYear() >= min && c.getYear() <= max).sorted(Comparator.comparingInt(Vehicle::getYear).reversed()).toList();
    }

    public List<Vehicle> getVehiclesByColor(String color){
        return inventory.stream().filter((c) -> c.getColor().equalsIgnoreCase(color)).sorted(Comparator.comparingDouble(Vehicle::getPrice)).toList();
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max){
        return inventory.stream().filter((c) -> c.getOdometer() >= min && c.getOdometer() <= max).sorted(Comparator.comparingDouble(Vehicle::getOdometer)).toList();
    }

    public List<Vehicle> getVehiclesByType(String vehicleType){
        return inventory.stream().filter((c) -> c.getVehicleType().equalsIgnoreCase(vehicleType)).sorted(Comparator.comparingDouble(Vehicle::getPrice)).toList();
    }

    public List<Vehicle> getVehiclesByVin(int vin){
        return inventory.stream().filter((c) -> c.getVin() == vin).toList();
    }

    public List<Vehicle> getAllVehicles(){
        return inventory.stream().sorted(Comparator.comparingDouble(Vehicle::getPrice)).toList();
    }

    public void addVehicle(Vehicle v) {
        inventory.add(v);
    }

    public void removeVehicle(Vehicle v){
        inventory.remove(v);
    }

}

package com.pluralsight.cars;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class TestDealershipClass {

    @org.junit.jupiter.api.Test
    void getVehiclesByPrice() {
        Dealership dealership = new Dealership("Scott clark Toyota", "392 shield rd", "980-269-4322");
        dealership.addVehicle(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        List<Vehicle> vehicle = List.of(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        assertIterableEquals(vehicle, dealership.getVehiclesByPrice(4500, 5500));

    }

    @Test
    void getVehiclesByMakeModel() {
        Dealership dealership = new Dealership("Scott clark Toyota", "392 shield rd", "980-269-4322");
        dealership.addVehicle(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        List<Vehicle> vehicle = List.of(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        assertIterableEquals(vehicle, dealership.getVehiclesByMakeModel("Toyota", "Corolla"));
    }

    @Test
    void getVehiclesByYear() {
        Dealership dealership = new Dealership("Scott clark Toyota", "392 shield rd", "980-269-4322");
        dealership.addVehicle(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        List<Vehicle> vehicle = List.of(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        assertIterableEquals(vehicle, dealership.getVehiclesByYear(2000, 2010));
    }

    @Test
    void getVehiclesByColor() {
        Dealership dealership = new Dealership("Scott clark Toyota", "392 shield rd", "980-269-4322");
        dealership.addVehicle(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        List<Vehicle> vehicle = List.of(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        assertIterableEquals(vehicle, dealership.getVehiclesByColor("silver"));
    }

    @Test
    void getVehiclesByMileage() {
        Dealership dealership = new Dealership("Scott clark Toyota", "392 shield rd", "980-269-4322");
        dealership.addVehicle(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        List<Vehicle> vehicle = List.of(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        assertIterableEquals(vehicle, dealership.getVehiclesByMileage(100000, 200000));
    }

    @Test
    void getVehiclesByType() {
        Dealership dealership = new Dealership("Scott clark Toyota", "392 shield rd", "980-269-4322");
        dealership.addVehicle(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        List<Vehicle> vehicle = List.of(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        assertIterableEquals(vehicle, dealership.getVehiclesByType("car"));
    }

}
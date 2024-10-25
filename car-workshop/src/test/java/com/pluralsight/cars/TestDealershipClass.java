package com.pluralsight.cars;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class TestDealershipClass {
    @org.junit.jupiter.api.Test
    void getVehiclesByPrice_should_return_vehicle_list_with_matching_prices() {
        Dealership dealership = new Dealership("Scott clark Toyota", "392 shield rd", "980-269-4322");
        dealership.addVehicle(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        List<Vehicle> vehicle = List.of(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        assertIterableEquals(vehicle, dealership.getVehiclesByPrice(4500, 5500));

    }

    @Test
    void getVehiclesByMakeModel_should_return_vehicle_list_with_matching_make_model() {
        Dealership dealership = new Dealership("Scott clark Toyota", "392 shield rd", "980-269-4322");
        dealership.addVehicle(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        List<Vehicle> vehicle = List.of(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        assertIterableEquals(vehicle, dealership.getVehiclesByMakeModel("Toyota", "Corolla"));
    }

    @Test
    void getVehiclesByYear_should_return_vehicle_list_with_matching_year() {
        Dealership dealership = new Dealership("Scott clark Toyota", "392 shield rd", "980-269-4322");
        dealership.addVehicle(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        List<Vehicle> vehicle = List.of(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        assertIterableEquals(vehicle, dealership.getVehiclesByYear(2000, 2010));
    }

    @Test
    void getVehiclesByColor_should_return_vehicle_list_with_matching_color() {
        Dealership dealership = new Dealership("Scott clark Toyota", "392 shield rd", "980-269-4322");
        dealership.addVehicle(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        List<Vehicle> vehicle = List.of(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        assertIterableEquals(vehicle, dealership.getVehiclesByColor("silver"));
    }

    @Test
    void getVehiclesByMileage_should_return_vehicle_list_with_matching_mileages() {
        Dealership dealership = new Dealership("Scott clark Toyota", "392 shield rd", "980-269-4322");
        dealership.addVehicle(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        List<Vehicle> vehicle = List.of(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        assertIterableEquals(vehicle, dealership.getVehiclesByMileage(100000, 200000));
    }

    @Test
    void getVehiclesByType_should_return_vehicle_list_with_matching_types() {
        Dealership dealership = new Dealership("Scott clark Toyota", "392 shield rd", "980-269-4322");
        dealership.addVehicle(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        List<Vehicle> vehicle = List.of(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        assertIterableEquals(vehicle, dealership.getVehiclesByType("car"));
    }

    @Test
    void getVehiclesByVin_should_return_list_of_cars_with_matching_vin() {
        Dealership dealership = new Dealership("Scott clark Toyota", "392 shield rd", "980-269-4322");
        dealership.addVehicle(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        List<Vehicle> vehicle = List.of(new Vehicle(2, 2009, "Toyota", "Corolla", "car", "Silver", 189000, 5000));

        assertIterableEquals(vehicle, dealership.getVehiclesByVin(2));
    }
}
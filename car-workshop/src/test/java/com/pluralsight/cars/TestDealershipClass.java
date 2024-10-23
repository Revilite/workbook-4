package com.pluralsight.cars;


import static org.junit.jupiter.api.Assertions.*;

class TestDealershipClass {

    @org.junit.jupiter.api.Test
    void getVehiclesByPrice() {
        Dealership dealership = new Dealership("Scott clark Toyota", "392 shield rd", "980-269-4322");
        dealership.addVehicle(new Vehicle(2, 2009, "Toyota", "Corrola", "car", "Silver", 189000, 5000));



    }
}
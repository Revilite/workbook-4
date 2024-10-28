package com.pluralsight.contract;

import com.pluralsight.cars.VehicleforDummies;

public class LeaseContract extends Contract {
    public LeaseContract(String date, String customerName, String customerEmail, VehicleforDummies vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }
}

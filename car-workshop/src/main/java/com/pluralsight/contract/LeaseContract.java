package com.pluralsight.contract;

import com.pluralsight.cars.VehicleforDummies;

public class LeaseContract extends Contract {
    public LeaseContract(String date, String customerName, String customerEmail, VehicleforDummies vehicleSold, double totalPrice, double monthlyPrice) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPrice);
    }

    @Override
    public double getMonthlyPrice() {
        return 0;
    }

    public double getTotalPrice() {
        return 0;
    }
}

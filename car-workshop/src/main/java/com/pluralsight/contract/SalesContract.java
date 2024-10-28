package com.pluralsight.contract;

import com.pluralsight.cars.VehicleforDummies;

public class SalesContract extends Contract {

    public SalesContract(String date, String customerName, String customerEmail, VehicleforDummies vehicleSold, double totalPrice, double monthlyPrice) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPrice);
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPrice() {
        return 0;
    }

}

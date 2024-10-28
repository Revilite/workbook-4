package com.pluralsight.contract;

import com.pluralsight.cars.VehicleforDummies;

public class LeaseContract extends Contract {
    protected double expectedEndingValue;
    protected double leaseFee;
    protected int loanAmount;



    public LeaseContract(String date, String customerName, String customerEmail, VehicleforDummies vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        expectedEndingValue = vehicleSold.getPrice() / 2;
        leaseFee = vehicleSold.getPrice() * .07;
        monthlyPayment = .04;
        loanAmount = 36;
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

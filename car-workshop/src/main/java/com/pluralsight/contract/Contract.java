package com.pluralsight.contract;

import com.pluralsight.cars.VehicleforDummies;

public abstract class Contract {
    protected String date;
    protected String customerName;
    protected String customerEmail;
    protected VehicleforDummies vehicleSold;
    protected double totalPrice;
    protected double monthlyPrice;

    public Contract(String date, String customerName, String customerEmail, VehicleforDummies vehicleSold, double totalPrice, double monthlyPrice) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
        this.totalPrice = totalPrice;
        this.monthlyPrice = monthlyPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public VehicleforDummies getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(VehicleforDummies vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public abstract double getTotalPrice();
    public abstract double getMonthlyPrice();
}

package com.pluralsight.contract;

import com.pluralsight.cars.VehicleforDummies;

public class SalesContract extends Contract {
    protected double salesTaxAmount;
    protected int recordingFee;
    protected int processingFee;
    protected boolean isFinancing;
    protected int loanAmount;


    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public int getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(int recordingFee) {
        this.recordingFee = recordingFee;
    }

    public int getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(int processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinancing() {
        return isFinancing;
    }

    public void setFinancing(boolean financing) {
        isFinancing = financing;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public SalesContract(String date, String customerName, String customerEmail, VehicleforDummies vehicleSold, boolean isFinancing) {
        super(date, customerName, customerEmail, vehicleSold);
        salesTaxAmount = .05;
        recordingFee = 100;
        if (vehicleSold.getPrice() < 10000) {
            processingFee = 295;
        } else {
            processingFee = 495;
        }
        this.isFinancing = isFinancing;

        if (isFinancing && vehicleSold.getPrice() >= 10000) {
            monthlyPayment = vehicleSold.getPrice() * .0425;
            loanAmount = 48;
        } else {
            monthlyPayment = vehicleSold.getPrice() * .0525;
            loanAmount = 24;
        }

    }

    @Override
    public double getTotalPrice() {
        return vehicleSold.getPrice() + loanAmount * (vehicleSold.getPrice() * monthlyPayment);
    }

    @Override
    public double getMonthlyPayment() {
        return monthlyPayment;
    }


}

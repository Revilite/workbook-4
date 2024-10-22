package com.pluralsight.HotelOperations;

public class Room {
    private final int numberOfBeds;
    private final double price;
    private boolean isOccupied;
    private boolean isDirty;
    private boolean isAvailable;


    public Room(int numberOfBeds, double price, boolean isOccupied, boolean isDirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
        if(isOccupied || isDirty){
            this.isAvailable = false;
        }
        else{
            this.isAvailable = true;
        }

    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}

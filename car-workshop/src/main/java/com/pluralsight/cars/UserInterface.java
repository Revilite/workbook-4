package com.pluralsight.cars;

public class UserInterface {
    private Dealership dealership;


    public static void display() {

    }
    private void init() {
        DealershipFileManager dfm = new DealershipFileManager();
        dfm.getDealership();
    }
}

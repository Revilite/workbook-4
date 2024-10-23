package com.pluralsight.cars;

public class UserInterface {
    private Dealership dealership;

    private void init() {
        DealershipFileManager dfm = new DealershipFileManager();
        dfm.getDealership();
    }

    public static void display() {

    }

}

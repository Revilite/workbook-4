package com.pluralsight.cars;

import java.io.*;

public class DealershipFileManager {
    public Dealership getDealership() {
        try {
            //Initializes BufferedReader, reads the first line (dealership line) creates a dealership
            BufferedReader buffRead = new BufferedReader(new FileReader("./src/main/resources/WorkshopFiles/inventory.csv"));
            String[] fileLine = buffRead.readLine().split("[|]");
            String dealershipName = fileLine[0];
            String dealershipAddress = fileLine[1];
            String dealershipPhoneNumber = fileLine[2];
            Dealership dealerShip = new Dealership(dealershipName, dealershipAddress, dealershipPhoneNumber);


            //Gets all the vehicles in the csv file and saves it to the dealerships inventory list
            String input;
            while ((input = buffRead.readLine()) != null) {
                String[] segments = input.split("[|]");
                int vin = Integer.parseInt(segments[0]);
                int year = Integer.parseInt(segments[1]);
                String make = segments[2];
                String model = segments[3];
                String vehicleType = segments[4];
                String color = segments[5];
                int odometer = Integer.parseInt(segments[6]);
                double price = Double.parseDouble(segments[7]);

                dealerShip.addVehicle(new VehicleforDummies(vin, year, make, model, vehicleType, color, odometer, price));
            }
            buffRead.close();
            return dealerShip;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveDealership(Dealership dealership) {
        try {

            //Overwrites the inventory.csv file with the dealership and all the vehicles
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./src/main/resources/WorkshopFiles/inventory.csv"));
            buffWrite.write(String.format("%s|%s|%s\n", dealership.getName(), dealership.getAddress(), dealership.getPhoneNumber()));
            for (VehicleforDummies vehicle : dealership.getAllVehicles()) {
                buffWrite.write(String.format("%s|%s|%s|%s|%s|%s|%s|%.2f\n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice()));
            }

            buffWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

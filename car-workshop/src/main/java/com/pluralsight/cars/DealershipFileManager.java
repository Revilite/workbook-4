package com.pluralsight.cars;

import java.io.*;

public class DealershipFileManager {
    public Dealership getDealership() {
        try {
            BufferedReader buffRead = new BufferedReader(new FileReader("./src/main/resources/WorkshopFiles/inventory.csv"));
            String[] fileLine = buffRead.readLine().split("[|]");
            Dealership dealerShip = new Dealership(fileLine[0], fileLine[1], fileLine[2]);

            String input;
            while ((input = buffRead.readLine()) != null) {
                String[] segments = input.split("[|]");
                dealerShip.addVehicle(new Vehicle(Integer.parseInt(segments[0]), Integer.parseInt(segments[1]), segments[2], segments[3], segments[4], segments[5], Integer.parseInt(segments[6]), Double.parseDouble(segments[7])));
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
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./src/main/resources/WorkshopFiles/inventory.csv"));
            buffWrite.write(String.format("%s|%s|%s\n", dealership.getName(), dealership.getAddress(), dealership.getPhoneNumber()));
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                buffWrite.write(String.format("%s|%s|%s|%s|%s|%s|%s|%.2f\n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice()));
            }

            buffWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

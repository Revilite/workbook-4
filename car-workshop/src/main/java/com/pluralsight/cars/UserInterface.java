package com.pluralsight.cars;

import com.pluralsight.cars.JavaHelpers.ColorCodes;

import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    private Dealership init() {
        DealershipFileManager dfm = new DealershipFileManager();
        this.dealership = dfm.getDealership();
        return dfm.getDealership();
    }

    public void display() {
        Scanner scan = new Scanner(System.in);
        init();
        String userChoice = "";
        System.out.println("Welcome to my dealership!!");
        while (!userChoice.equals("99")) {
            System.out.println("""
                    Please select what you want to search by!
                    
                    Price              (1)
                    Make/Model         (2)
                    Year               (3)
                    Color              (4)
                    Mileage            (5)
                    Type               (6)
                    All                (7)
                    Add a vehicle      (8)
                    Remove a vehicle   (9)
                    Quit               (99)
                    """);
            userChoice = scan.nextLine();

            switch (userChoice) {
                case ("1"):
                    processGetByPriceRequest();
                    break;
                case ("2"):
                    processGetByMakeModel();
                    break;
            }
        }
    }

    public String displayVehicles(Vehicle vehicle) {
        return String.format(String.format("""
                        %sMake: %s %s Model: %s %s Year: %s %s Color: %s %s Mileage:  %s  %s
                        """,
                ColorCodes.YELLOW, vehicle.getMake(),
                ColorCodes.GREEN, vehicle.getModel(),
                ColorCodes.BLUE, vehicle.getYear(),
                ColorCodes.RED, vehicle.getColor(),
                ColorCodes.PURPLE, vehicle.getOdometer(),
                ColorCodes.RESET));
    }

    public void processGetByPriceRequest() {
        Scanner scan = new Scanner(System.in);
        boolean userMinNaN = true;
        boolean userMaxNaN = true;
        int minNumber = 0;
        int maxNumber = 0;
        while (userMinNaN) {
            System.out.println("What is the minimum price you are looking for?");
            String min = scan.nextLine();
            try {
                minNumber = Integer.parseInt(min);
                userMinNaN = false;
            } catch (NumberFormatException e) {
                System.out.println("That is not a number");
            }
        }
        while (userMaxNaN) {
            System.out.println("What is the maximum price you are looking for?");
            try {
                String max = scan.nextLine();
                maxNumber = Integer.parseInt(max);
                userMaxNaN = false;
            } catch (NumberFormatException e) {
                System.out.println("That is not a number");
            }
        }
        for (Vehicle vehicle : dealership.getVehiclesByPrice(minNumber, maxNumber)) {
            System.out.print(displayVehicles(vehicle));
        }
    }

    public void processGetByMakeModel() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the make and the model of the car?");
        String[] makeModel = scan.nextLine().trim().split(" ");

        for(Vehicle vehicle : dealership.getVehiclesByMakeModel(makeModel[0], makeModel[1])){
            System.out.print(displayVehicles(vehicle));
        }
    }

}

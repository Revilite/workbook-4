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
                    processGetByMakeModelRequest();
                    break;
                case ("3"):
                    processGetByYearRequest();
                    break;
                case ("4"):
                    processGetByColorRequest();
                    break;
                case ("5"):
                    processGetByMileageRequest();
                    break;
                case ("6"):
                    processGetByTypeRequest();
                    break;
                case("7"):
                    processGetAllRequest();
                    break;
                case("8"):

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

    public int[] getUserRange(String prompt) {
        Scanner scan = new Scanner(System.in);
        boolean userMinNaN = true;
        boolean userMaxNaN = true;
        int minNumber = 0;
        int maxNumber = 0;
        while (userMinNaN) {
            System.out.println("What is the minimum " + prompt + " you are looking for?");
            String min = scan.nextLine();
            try {
                minNumber = Integer.parseInt(min);
                userMinNaN = false;
            } catch (NumberFormatException e) {
                System.out.println("That is not a number");
            }
        }
        while (userMaxNaN) {
            System.out.println("What is the maximum " + prompt + " you are looking for?");
            try {
                String max = scan.nextLine();
                maxNumber = Integer.parseInt(max);
                userMaxNaN = false;
            } catch (NumberFormatException e) {
                System.out.println("That is not a number");
            }
        }
        return new int[]{minNumber, maxNumber};
    }

    public void processGetByPriceRequest() {
        int[] userRange = getUserRange("price");
        for (Vehicle vehicle : dealership.getVehiclesByPrice(userRange[0], userRange[1])) {
            System.out.print(displayVehicles(vehicle));
        }
    }

    public void processGetByMakeModelRequest() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the make and the model of the car?");
        String[] makeModel = scan.nextLine().trim().split(" ");

        for (Vehicle vehicle : dealership.getVehiclesByMakeModel(makeModel[0], makeModel[1])) {
            System.out.print(displayVehicles(vehicle));
        }
    }

    public void processGetByYearRequest() {
        int[] userRange = getUserRange("year");
        for (Vehicle vehicle : dealership.getVehiclesByYear(userRange[0], userRange[1])) {
            System.out.print(displayVehicles(vehicle));
        }
    }

    public void processGetByColorRequest() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the color of the car?");
        String color = scan.nextLine();

        for (Vehicle vehicle : dealership.getVehiclesByColor(color)) {
            System.out.print(displayVehicles(vehicle));
        }
    }

    public void processGetByMileageRequest() {
        int[] userRange = getUserRange("mileage");
        for (Vehicle vehicle : dealership.getVehiclesByMileage(userRange[0], userRange[1])) {
            System.out.print(displayVehicles(vehicle));
        }
    }

    public void processGetByTypeRequest() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the vehicle type? (car, SUV, Truck, van)");
        String type = scan.nextLine();

        for (Vehicle vehicle : dealership.getVehiclesByType(type)) {
            System.out.print(displayVehicles(vehicle));
        }
    }

    public void processGetAllRequest() {
        for(Vehicle vehicle : dealership.getAllVehicles()){
            System.out.print(displayVehicles(vehicle));
        }
    }

}

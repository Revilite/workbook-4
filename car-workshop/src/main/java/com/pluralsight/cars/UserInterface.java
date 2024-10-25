package com.pluralsight.cars;

import com.pluralsight.cars.JavaHelpers.ColorCodes;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Delayed;

public class UserInterface {
    private Dealership dealership;

    private void init() {
        DealershipFileManager dfm = new DealershipFileManager();
        this.dealership = dfm.getDealership();
    }

    public void display() {
        Scanner scan = new Scanner(System.in);
        init();
        String userChoice = "";
        System.out.println(String.format("""
                       %s╔════════════════════════════╗
                       ║ Welcome to my dealership!! ║
                       ╚════════════════════════════╝%s
                """, ColorCodes.GREEN, ColorCodes.RESET));

        while (!userChoice.equals("99")) {
            System.out.println(String.format("""
                    %s╔══════════════════════════════════════════╗
                    ║ Please select what you want to search by!║
                    ╠══════════════════════════════════════════╣
                    ║ Price                              (1)   ║
                    ║ Make/Model                         (2)   ║
                    ║ Year                               (3)   ║
                    ║ Color                              (4)   ║
                    ║ Mileage                            (5)   ║
                    ║ Type                               (6)   ║
                    ║ All                                (7)   ║
                    ║ Add a vehicle                      (8)   ║
                    ║ Remove a vehicle                   (9)   ║
                    ║ Quit                               (99)  ║
                    ╚══════════════════════════════════════════╝%s
                    """, ColorCodes.BLUE, ColorCodes.RESET));
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
                case ("7"):
                    processGetAllRequest();
                    break;
                case ("8"):
                    processAddVehicleRequest();
                    break;
                case ("9"):
                    processRemoveVehicleRequest();
                    break;
                case ("99"):
                    break;
                default:
                    System.out.println("Please choose one of the options");


            }
        }
    }

    public String displayVehicles(List<Vehicle> listOfVehicle) {
        StringBuilder sb = new StringBuilder();
        for (Vehicle vehicle : listOfVehicle) {
            String make = String.format(ColorCodes.YELLOW + "  %-15s ", vehicle.getMake() + ColorCodes.RESET);
            String model = String.format(ColorCodes.GREEN + " %-14s ", vehicle.getModel() + ColorCodes.RESET);
            String year = String.format(ColorCodes.BLUE + "      %-14s ", vehicle.getYear() + ColorCodes.RESET);
            String color = String.format(ColorCodes.RED + " %-18s ", vehicle.getColor() + ColorCodes.RESET);
            String mileage = String.format(ColorCodes.PURPLE + " %-14s ", vehicle.getOdometer() + ColorCodes.RESET);
            String price = String.format(ColorCodes.WHITE + " %-10.2f ", vehicle.getPrice());

            if (listOfVehicle.get(0) == vehicle) {


                sb.append("╔════════════╦══════════════╦════════════╦══════════════╦═════════════╦═════════════╗\n");
                sb.append("║    Make:   ║   Model:     ║    Year:   ║    Color:    ║   Mileage:  ║   Price:    ║\n");
                sb.append("╠════════════╩══════════════╩════════════╩══════════════╩═════════════╩═════════════╣\n");
                sb.append("║").append(make).append(model).append(year).append(color).append(mileage).append(price).append(ColorCodes.RESET).append("║").append("\n");


            } else if (listOfVehicle.get(listOfVehicle.size() - 1) == vehicle) {
                sb.append("║").append(make).append(model).append(year).append(color).append(mileage).append(price).append(ColorCodes.RESET).append("║").append("\n");
                sb.append("╚═══════════════════════════════════════════════════════════════════════════════════╝\n");

                return sb.toString();
            }
            else{
            sb.append("║").append(make).append(model).append(year).append(color).append(mileage).append(price).append(ColorCodes.RESET).append("║").append("\n");
            }

        }


        return sb.toString();
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
        System.out.println(displayVehicles(dealership.getVehiclesByPrice(userRange[0], userRange[1])));
    }

    public void processGetByMakeModelRequest() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the make and the model of the car?");
        String[] makeModel = scan.nextLine().trim().split(" ");

        System.out.println(displayVehicles(dealership.getVehiclesByMakeModel(makeModel[0], makeModel[1])));
    }

    public void processGetByYearRequest() {
        int[] userRange = getUserRange("year");
        System.out.println(displayVehicles(dealership.getVehiclesByYear(userRange[0], userRange[1])));
    }

    public void processGetByColorRequest() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the color of the car?");
        String color = scan.nextLine();
        System.out.println(displayVehicles(dealership.getVehiclesByColor(color)));
    }

    public void processGetByMileageRequest() {
        int[] userRange = getUserRange("mileage");
        System.out.println(displayVehicles(dealership.getVehiclesByMileage(userRange[0], userRange[1])));
    }

    public void processGetByTypeRequest() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the vehicle type? (car, SUV, Truck, van)");
        String type = scan.nextLine();

        System.out.println(displayVehicles(dealership.getVehiclesByType(type)));
    }

    public void processGetAllRequest() {
        System.out.println(displayVehicles(dealership.getAllVehicles()));
    }

    public String prompt(String prompt) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the " + prompt);
        return scan.nextLine();
    }

    public int convertToInt(String input) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Not a number, Please enter a number");
                input = scan.nextLine();
            }
        }
    }

    public double convertToDouble(String input) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Not a number, Please enter a number");
                input = scan.nextLine();
            }
        }
    }

    public void processAddVehicleRequest() {
        DealershipFileManager dfm = new DealershipFileManager();
        int vin = convertToInt(prompt("vin number"));
        String make = prompt("make");
        String model = prompt("model");
        String type = prompt("type");
        String color = prompt("color");
        int year = convertToInt(prompt("year"));
        int mileage = convertToInt(prompt("mileage"));
        double price = convertToDouble(prompt("price"));

        dealership.addVehicle(new Vehicle(vin, year, make, model, type, color, mileage, price));
        try {
            dfm.saveDealership(dealership);
            System.out.println("Car added!");
        } catch (IOException e) {
            System.out.println("Unable to save to file");
        }
    }

    public void processRemoveVehicleRequest() {
        DealershipFileManager dfm = new DealershipFileManager();
        int vin = convertToInt(prompt("vin number"));
        try {
            dealership.removeVehicle(dealership.getVehiclesByVin(vin).get(0));
            System.out.println("Car removed!");
        } catch (RuntimeException e) {
            System.out.println("Unable to find vehicle");
        }

        try {
            dfm.saveDealership(dealership);
        } catch (IOException e) {
            System.out.println("Unable to save to file");
        }
    }
}

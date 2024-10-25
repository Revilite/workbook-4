package com.pluralsight.cars;

import com.pluralsight.cars.JavaHelpers.ColorCodes;

import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    //takes inventory.csv information and brings it into memory.
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
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        for (Vehicle vehicle : listOfVehicle) {
            //Gets the color and the variables formatted
            String make = String.format(ColorCodes.YELLOW + "  %-16s ", vehicle.getMake() + ColorCodes.RESET);
            String model = String.format(ColorCodes.GREEN + " %-14s ", vehicle.getModel() + ColorCodes.RESET);
            String year = String.format(ColorCodes.BLUE + "      %-14s ", vehicle.getYear() + ColorCodes.RESET);
            String color = String.format(ColorCodes.RED + " %-18s ", vehicle.getColor() + ColorCodes.RESET);
            String mileage = String.format(ColorCodes.PURPLE + " %-14s ", vehicle.getOdometer() + ColorCodes.RESET);
            String price = String.format(ColorCodes.WHITE + " %-14s ", nf.format(vehicle.getPrice()));

            //Used if there is only 1 item in the list
            if (listOfVehicle.size() == 1) {
                sb.append("╔═════════════╦══════════════╦════════════╦══════════════╦═════════════╦═════════════════╗\n");
                sb.append("║    Make:    ║   Model:     ║    Year:   ║    Color:    ║   Mileage:  ║   Price:        ║\n");
                sb.append("╠═════════════╩══════════════╩════════════╩══════════════╩═════════════╩═════════════════╣\n");
                sb.append("║").append(make).append(model).append(year).append(color).append(mileage).append(price).append(ColorCodes.RESET).append("║").append("\n");
                sb.append("╚════════════════════════════════════════════════════════════════════════════════════════╝\n");
            }
            //Used as the heading for the list
            else if (listOfVehicle.get(0) == vehicle) {
                sb.append("╔═════════════╦══════════════╦════════════╦══════════════╦═════════════╦═════════════════╗\n");
                sb.append("║    Make:    ║   Model:     ║    Year:   ║    Color:    ║   Mileage:  ║   Price:        ║\n");
                sb.append("╠═════════════╩══════════════╩════════════╩══════════════╩═════════════╩═════════════════╣\n");
                sb.append("║").append(make).append(model).append(year).append(color).append(mileage).append(price).append(ColorCodes.RESET).append("║").append("\n");

            //Used as the footer for the list
            } else if (listOfVehicle.get(listOfVehicle.size() - 1) == vehicle) {
                sb.append("║").append(make).append(model).append(year).append(color).append(mileage).append(price).append(ColorCodes.RESET).append("║").append("\n");
                sb.append("╚════════════════════════════════════════════════════════════════════════════════════════╝\n");

                return sb.toString();
            }
            //Used as each individual middle list.
            else {
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
            System.out.println("What is the minimum " + prompt + " you are looking for? (Enter 'x' to break)");
            String min = scan.nextLine();
            try {
                //Returns a unsearchable value if the user inputs x
                if (min.equalsIgnoreCase("x")) {
                    return new int[]{-1, -1};
                }
                minNumber = Integer.parseInt(min);
                //checks if the users number is positive
                if (minNumber < 0) {
                    System.out.println("Please enter a positive number");
                } else {
                    userMinNaN = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("That is not a number");
            }
        }
        while (userMaxNaN) {
            System.out.println("What is the maximum " + prompt + " you are looking for? (Enter 'x' to break)");
            try {
                String max = scan.nextLine();
                //Returns a unsearchable value if the user inputs x
                if (max.equalsIgnoreCase("x")) {
                    return new int[]{-1, -1};
                }
                maxNumber = Integer.parseInt(max);
                //checks if the users number is positive
                if (maxNumber < 0) {
                    System.out.println("Please enter a positive number");
                } else {
                    userMaxNaN = false;
                }

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
        System.out.println("What is the make and the model of the car? (Enter 'x' to exit)");
        String userInput = scan.nextLine();
        if (userInput.equalsIgnoreCase("x")) {
            return;
        }
        String[] makeModel = userInput.trim().split(" ");

        System.out.println(displayVehicles(dealership.getVehiclesByMakeModel(makeModel[0], makeModel[1])));
    }

    public void processGetByYearRequest() {
        int[] userRange = getUserRange("year");
        System.out.println(displayVehicles(dealership.getVehiclesByYear(userRange[0], userRange[1])));
    }

    public void processGetByColorRequest() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the color of the car? (Enter 'x' to exit)");
        String color = scan.nextLine();
        if (color.equalsIgnoreCase("x")) {
            return;
        }
        System.out.println(displayVehicles(dealership.getVehiclesByColor(color)));
    }

    public void processGetByMileageRequest() {
        int[] userRange = getUserRange("mileage");
        System.out.println(displayVehicles(dealership.getVehiclesByMileage(userRange[0], userRange[1])));
    }

    public void processGetByTypeRequest() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the vehicle type? (car, SUV, Truck, Van, Hypercar) (Enter 'x' to exit)");
        String type = scan.nextLine();
        if (type.equalsIgnoreCase("x")) {
            return;
        }

        System.out.println(displayVehicles(dealership.getVehiclesByType(type)));
    }

    public void processGetAllRequest() {
        System.out.println(displayVehicles(dealership.getAllVehicles()));
    }

    public String prompt(String prompt) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the " + prompt + " (Enter 'x' to exit)");
        String input = scan.nextLine();
        if (input.equalsIgnoreCase("x")) {
            return null;
        }
        return input;
    }

    public int convertToInt(String input) {
        Scanner scan = new Scanner(System.in);

        //Checks if the user enters 'x' returns a unsearchable number
        if (input == null) {
            return -1;
        }
        while (true) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Not a number, Please enter a number");
                input = scan.nextLine();
                if (input.equalsIgnoreCase("x")) {
                    return -1;
                }
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
                if (input.equalsIgnoreCase("x")) {
                    return -1;
                }
            }
        }
    }

    public void processAddVehicleRequest() {
        DealershipFileManager dfm = new DealershipFileManager();
        int vin = convertToInt(prompt("vin number"));
        if (vin == -1) {
            return;
        }
        String make = prompt("make");
        if (make == null) {
            return;
        }
        String model = prompt("model");
        if (model == null) {
            return;
        }
        String type = prompt("type");
        if (type == null) {
            return;
        }
        String color = prompt("color");
        if (color == null) {
            return;
        }
        int year = convertToInt(prompt("year"));
        if (year == -1) {
            return;
        }
        int mileage = convertToInt(prompt("mileage"));
        if (mileage == -1) {
            return;
        }
        double price = convertToDouble(prompt("price"));
        if (price == -1) {
            return;
        }

        dealership.addVehicle(new Vehicle(vin, year, make, model, type, color, mileage, price));
        dfm.saveDealership(dealership);
        System.out.println(ColorCodes.GREEN + "Car added!" + ColorCodes.RESET);

    }

    public void processRemoveVehicleRequest() {
        DealershipFileManager dfm = new DealershipFileManager();
        int vin = convertToInt(prompt("vin number"));
        if (vin == -1) {
            return;
        }

        dealership.removeVehicle(dealership.getVehiclesByVin(vin).get(0));
        dfm.saveDealership(dealership);
        System.out.println(ColorCodes.RED + "Car removed" + ColorCodes.RESET);
    }
}

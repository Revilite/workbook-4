package com.pluralsight.HotelOperations;

public class Main {
    public static void main(String[] args) {
        Room room1 = new Room(2, 249.99, false, false);

        Reservation reservation1 = new Reservation("double", 2, true);

        System.out.println(String.format("$%.2f", reservation1.getReservationTotal()));

        Employee employee1 = new Employee(1, "Jacob", "Kitchen", 17.50, 42.5);

        System.out.println(employee1.getTotalPay());
        System.out.println(employee1.getRegularHours());
        System.out.println(employee1.getOvertimeHours());

    }
}

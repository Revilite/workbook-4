package com.pluralsight.hotel;

public class HotelApp {
    public static void main(String[] args) {

        int numberOfBeds = 2;
        boolean isClean = true;
        boolean isOccupied = true;

        Room r = new Room(isClean, isOccupied, numberOfBeds);


        // com.pluralsight.hotel.Room should not be available
        boolean isRoomAvailable = r.isAvailable();

        if (isRoomAvailable) {
            System.out.println("The room is available");
        } else {
            System.out.println("The room is not available");
        }


        r.setOccupied(false);
        r.setClean(true);
        isRoomAvailable = r.isAvailable();
        if (isRoomAvailable) {
            System.out.println("The room is available");
        } else {
            System.out.println("The room is not available");
        }

    }
}

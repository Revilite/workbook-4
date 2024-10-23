package com.pluralsight.hotel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTheRoom {

    @Test
    void when_Room_isOccupied_it_is_not_available() {
        int numberOfBeds = 2;
        boolean isClean = true;
        boolean isOccupied = true;

        Room r = new Room(isClean, isOccupied, numberOfBeds);

        assertFalse(r.isAvailable());
    }

    @Test
    void when_Room_isNotClean_it_is_not_available(){
        int numberOfBeds = 2;
        boolean isClean = false;
        boolean isOccupied = false;

        Room r = new Room(isClean, isOccupied, numberOfBeds);

        assertFalse(r.isAvailable());
    }

    @Test
    void when_Room_isDownForMaitenance_it_is_not_available(){
        int numberOfBeds = 2;
        boolean isClean = false;
        boolean isOccupied = false;
        //

        Room r = new Room(isClean, isOccupied, numberOfBeds);

        //Act
        r.setDownForMaintenance(true);

        //Assert
        assertFalse(r.isAvailable());
    }

    @Test
    void
}
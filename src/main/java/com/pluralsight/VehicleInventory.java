package com.pluralsight;

public class VehicleInventory {
    public static void main(String[] args) {
        Vehicle[] cars = new Vehicle[20];
        int filledSpots = 0;

        // Pre-load
        cars[0] = new Vehicle(101121,"Ford Explorer","Red",45000,13500);
        cars[1] = new Vehicle(101122,"Toyota Camry","Blue",60000,11000);
        cars[2] = new Vehicle(101123,"Chevrolet Malibu","Black",50000,9700);
        cars[3] = new Vehicle(101124,"Honda Civic","White",70000,7500);
        cars[4] = new Vehicle(101125,"Subaru Outback","Green",55000,14500);
        cars[5] = new Vehicle(101126,"Jeep Wrangler","Yellow",30000,16000);


    }
}

package com.pluralsight;

import java.util.Scanner;

public class VehicleInventory {
    static int filledSpots;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle[] cars = new Vehicle[20];
        int command;

        // Pre-load
        cars[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        cars[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        cars[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        cars[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        cars[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        cars[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        do {
            System.out.println("What do you want to do?\n");
            System.out.println("  1 - List all vehicles");
            System.out.println("  2 - Search by make/model");
            System.out.println("  3 - Search by price range");
            System.out.println("  4 - Search by color");
            System.out.println("  5 - Add a vehicle");
            System.out.println("  6 - Quit\n");
            System.out.print("Enter your command: ");

            command = scanner.nextInt();

            switch (command) {
                case 1:
                    listAllVehicles(cars);
                    break;
                case 2:
                    findVehiclesByMakeModel(cars, scanner);
                    break;
                case 3:
                    findPriceRange();
                    break;
                case 4:
                    findCarByColor();
                    break;
                case 5:
                    addNewVehicle();

            }
        } while (command != 6);
        System.out.println("---");
    }

    public static void listAllVehicles (Vehicle[] cars) {
        for (Vehicle car : cars){
            System.out.println((filledSpots + 1) + ". " + car.getMakeModel());
            filledSpots++;
        }
    }

    public static void findVehiclesByMakeModel(Vehicle[] cars, Scanner input) {
        input.nextLine();
        System.out.print("Search for makeModel: ");
        String search = input.nextLine();
        for (Vehicle car: cars) {
            String currentMakeModel = car.getMakeModel();
            if (currentMakeModel.contains(search)) System.out.printf("%s is in lot no.%d%n", currentMakeModel,
                    (filledSpots + 1));
        }
        System.out.println("Car not in the lot");
    }
}

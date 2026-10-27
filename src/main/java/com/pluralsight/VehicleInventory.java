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
            filledSpots = getFilledSpots(cars);
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
                    findPriceRange(cars, scanner);
                    break;
                case 4:
                    findCarByColor(cars, scanner);
                    break;
                case 5:
                    addNewVehicle(cars, scanner);
                    break;
                case 6:
                    System.out.println("--Quit");
                    break;
                default:
                    System.out.println("--Invalid input");
                    break;
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

    public static void findPriceRange(Vehicle[] cars, Scanner input) {
        input.nextLine();
        System.out.print("Enter Price Range(top): ");
        double price = Double.parseDouble(input.nextLine());

        System.out.println("Cars within budget: ");
        for (int i = 0; i < filledSpots; i++) {
            double carPrice = cars[i].getPrice();
            if (price <= carPrice) {
                System.out.printf("{Make: %s, Price: $%.2f}%n", cars[i].getMakeModel(), cars[i].getPrice());
            }
        }
    }

    public static void findCarByColor(Vehicle[] cars, Scanner input) {
        input.nextLine();
        System.out.print("Search for Car by Color: ");
        String search = input.nextLine();

        for (int i = 0; i < filledSpots; i++) {
            String currentCarColor = cars[i].getColor();
            if (currentCarColor.contains(search)) System.out.printf("%s is in lot no.%d, Make: %s%n", currentCarColor,
                    (i+1), cars[i].getMakeModel());
        }
    }

    public static void addNewVehicle(Vehicle[] cars, Scanner input) {
        input.nextLine();
        System.out.print("Add a new car to the lot (vehicleID, makeModel, color, odometer, price): ");
        String details = input.nextLine();
        String[] carSpecs = details.trim().split(", ");

        if (getFilledSpots(cars) >= cars.length) {
            System.out.println("No more open spaces.");
        } else {
            long vehicleId = Long.parseLong(carSpecs[0].trim());
            String makeModel = carSpecs[1];
            String color = carSpecs[2];
            int odometer = Integer.parseInt(carSpecs[3].trim());
            double price = Double.parseDouble(carSpecs[4].trim());

            Vehicle car = new Vehicle(
                    vehicleId,
                    makeModel,
                    color,
                    odometer,
                    price);

            cars[filledSpots] = car;

            System.out.printf("Added %s to the lot%n", makeModel);
        }
    }

    public static int getFilledSpots(Vehicle[] cars) {
        int filled = 0;
        for (Vehicle car : cars) {
            if( car != null) {
                filled ++;
            }
        }
        return filled;
    }
}

package org.sep26.controllers;
import org.sep26.db.DBExecute;
import org.sep26.models.Car;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class CarController {
    private Vector<Car> cars;
    private Scanner scanner;

    public CarController() {
        cars = new Vector<Car>();
        scanner = new Scanner(System.in);
    }

    public void insertCar() {
        System.out.print("Plate: ");
        int plate = Integer.parseInt(scanner.nextLine());
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Make: ");
        String make = scanner.nextLine();

        Car car = new Car(plate, model, make);
        cars.add(car);

        // Call execute method with the car details
        String query = "INSERT INTO cars (plate, model, make) VALUES (?, ?, ?);";
        try {
            DBExecute.execute(query, plate, model, make);
        } catch (SQLException e) {
            System.err.println("Failed to insert car: " + e.getMessage());
        }
    }

    public void updateCar(){
        System.out.print("Enter the plate number of the car you want to update: ");
        int plate = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the new model: ");
        String model = scanner.nextLine();
        System.out.print("Enter the new make: ");
        String make = scanner.nextLine();

        String query = "UPDATE cars SET model = ?, make = ? WHERE plate = ?;";
        try {
            DBExecute.execute(query, model, make, plate);
        } catch (SQLException e) {
            System.err.println("Failed to update car: " + e.getMessage());
        }
    }

    public void deleteCar(){
        System.out.print("Enter the plate number of the car you want to delete: ");
        int plate = Integer.parseInt(scanner.nextLine());

        String query = "DELETE FROM cars WHERE plate = ?;";
        try {
            DBExecute.execute(query, plate);
        } catch (SQLException e) {
            System.err.println("Failed to delete car: " + e.getMessage());
        }
    }

    public void showCarByIdOrPlate() {
        System.out.print("Enter the ID or plate number of the car you want to show: ");
        int plateOrId = Integer.parseInt(scanner.nextLine());

        String query = "SELECT * FROM cars WHERE id = ? OR plate = ?;";
        try {
            DBExecute.execute(plateOrId, query);  // Send the same value for both parameters
        } catch (SQLException e) {
            System.err.println("Failed to show car: " + e.getMessage());
        }
    }

    public void showCars() {
        String query = "SELECT * FROM cars;";
        try {
            DBExecute.execute(query);
        } catch (SQLException e) {
            System.err.println("Failed to show cars: " + e.getMessage());
        }
    }
}



package org.sep26.controllers;

import org.sep26.config.DBConnect;
import org.sep26.models.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            execute(query, plate, model, make);
        } catch (SQLException e) {
            System.err.println("Failed to insert car: " + e.getMessage());
        }
    }

    public void execute(String query, int plate, String model, String make) throws SQLException {
         DBConnect conndb = new DBConnect(); // Create a new DBConnect instance
         Connection conn = conndb.connect();
         PreparedStatement stmt = conn.prepareStatement(query);

         try {
            stmt.setInt(1, plate);
            stmt.setString(2, model);
            stmt.setString(3, make);
            stmt.executeUpdate();
            System.out.println("Car added successfully");
        } catch (SQLException e) {
            System.err.println("Error while adding car: " + e.getMessage());
            throw e; // Rethrow the exception for further handling
        }
    }
}

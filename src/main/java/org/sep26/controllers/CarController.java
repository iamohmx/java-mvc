package org.sep26.controllers;

import org.sep26.config.DBConnect;
import org.sep26.models.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class CarController {
    private Vector<Car> Cars;
    private Scanner scanner;

    public CarController() {
        Cars = new Vector<Car>();
        scanner = new Scanner(System.in);
    }

    public void execute() {
        try {
            System.out.print("Plate:");
            int plate = Integer.parseInt(scanner.nextLine());
            System.out.print("Model:");
            String model = scanner.nextLine();
            System.out.print("Make:");
            String make = scanner.nextLine();
            Car car = new Car(plate, model, make);

//        Cars.add(car);
            String query = "INSERT INTO cars (plate, model, make) VALUES (?, ?, ?);";
//            System.out.println();

            try {
                DBConnect conndb = new DBConnect();
                Connection conn = conndb.connect();
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setInt(1, car.plate);
                stmt.setString(2, car.model);
                stmt.setString(3, car.make);
                stmt.executeUpdate();
                System.out.println("Car added successfully");
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }



    }
}

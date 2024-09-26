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
    }

    public void addCar() {
        try {
            scanner = new Scanner(System.in);
            System.out.println("Enter plate number: ");
            int plate = scanner.nextInt();
            System.out.println("Enter model: ");
            String model = scanner.next();
            System.out.println("Enter make: ");
            String make = scanner.next();
            Car car = new Car(plate, model, make);
//        Cars.add(car);
            String query = "INSERT INTO cars (plate, model, make) VALUES (?, ?, ?)";
            System.out.println(query);

            try {
                DBConnect conndb = new DBConnect();
                Connection conn = conndb.connect();
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setInt(1, car.plate);
                stmt.setString(2, car.model);
                stmt.setString(3, car.make);
                stmt.executeUpdate();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}

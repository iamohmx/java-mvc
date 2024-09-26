package org.sep26;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import org.sep26.config.DBConnect;
import org.sep26.controllers.CarController;
import org.sep26.controllers.LogicController;
import org.sep26.models.Car;

import java.sql.SQLException;
import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void insertCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Plate: ");
        int plate = Integer.parseInt(scanner.nextLine());
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Make: ");
        String make = scanner.nextLine();

        LogicController logicController = new LogicController();
        logicController.insertCar(plate, model, make);
    }
    public static void main(String[] args) {
        insertCar();
    }
}
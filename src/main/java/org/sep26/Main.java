package org.sep26;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import org.sep26.controllers.LogicController;
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

    public static void updateCar() {

    }

    public static void searchCar() {

    }

    public static void deleteCar() {

    }

    public static void viewCars() {

    }

    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        while (cont) {
            System.out.println("=== Main Menu ===");
            System.out.println("1 Add Car.");
            System.out.println("2 Update Car.");
            System.out.println("3 Search Car.");
            System.out.println("4 Delete Car.");
            System.out.println("9 View Cars.");
            System.out.println("0 Exit");
            System.out.print("Your choice:");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    insertCar();
                    break;
                case "2":
                    updateCar();
                    break;
                case "3":
                    searchCar();
                    break;
                case "4":
                    deleteCar();
                    break;
                case "9":
                    viewCars();
                    break;
                case "0":
                    cont = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    public static void main(String[] args) {
        insertCar();
    }
}
package org.sep26;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import org.sep26.config.DBConnect;
import org.sep26.controllers.CarController;
import org.sep26.controllers.TransactionController;
import org.sep26.models.Car;

import java.sql.SQLException;
import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
//    public static void insertCar() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Plate: ");
//        int plate = Integer.parseInt(scanner.nextLine());
//        System.out.print("Model: ");
//        String model = scanner.nextLine();
//        System.out.print("Make: ");
//        String make = scanner.nextLine();
//    }
//    public static void mainMenu() {
//        CarController carController = new CarController();
//        Scanner scanner = new Scanner(System.in);
//        int choice = 0;
//        do {
//            System.out.println("1. Insert car");
//            System.out.println("2. Show cars");
//            System.out.println("3. Show car by ID or plate");
//            System.out.println("4. Update car");
//            System.out.println("5. Delete car");
//            System.out.println("9. Exit");
//            System.out.print("Enter choice: ");
//            choice = Integer.parseInt(scanner.nextLine());
//            switch (choice) {
//                case 1:
//                    carController.insertCar();
//                    break;
//                case 2:
//                    carController.showCars();
//                    break;
//                case 3:
//                    carController.showCarByIdOrPlate();
//                    break;
//                case 4:
//                    carController.updateCar();
//                    break;
//                case 5:
//                    carController.deleteCar();
//                    break;
//                case 9:
//                    System.out.println("Exiting...");
//                    break;
//                default:
//                    System.out.println("Invalid choice");
//            }
//        } while (choice != 9);
//    }


    public static void mainMenu(){
        TransactionController transactionController = new TransactionController();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("1. Create transaction");
            System.out.println("2. Show transactions");
            System.out.println("3. Show transaction by ID");
            System.out.println("4. Update transaction");
            System.out.println("5. Delete transaction");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    transactionController.createTransaction();
                    break;
                case 2:
                    transactionController.getAllTransactions();
                    break;
                case 3:
                    transactionController.getTransaction();
                    break;
                case 4:
                    transactionController.updateTransaction();
                    break;
                case 5:
                    transactionController.deleteTransaction();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 9);
    }
    public static void main(String[] args) {
        mainMenu();
//        SELECT trans_id, good, CONCAT(day, month, year) AS dateTime, quantity, amount FROM `transactions`;
    }
}
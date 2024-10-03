package org.sep26.controllers;

import org.sep26.config.DBConnect;
import org.sep26.db.TransactionDB;
import org.sep26.models.Transaction;

import java.sql.*;
import java.util.Scanner;
import java.util.Vector;

import static java.lang.System.currentTimeMillis;

public class TransactionController {

    private Vector<Transaction> transactions;
    private Scanner scanner;

    public TransactionController() {
        // Constructor
        transactions = new Vector<Transaction>();
        scanner = new Scanner(System.in);
    }

    public void createTransaction() {
        // Create a new transaction
        System.out.print("Goods ID: ");
        int goods_id = Integer.parseInt(scanner.nextLine());
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Amount: ");
        int amount = Integer.parseInt(scanner.nextLine());
        Date date = new Date(currentTimeMillis());

        Transaction transaction = new Transaction(goods_id, date, quantity, amount, price);
        transactions.add(transaction);

        String query = "INSERT INTO transactions (goods_id, date, quantity, amount, price) VALUES (?, ?, ?, ?, ?);";
        try{
            // Call execute method with the transaction details
            // DBExecute.execute(query, goods_id, date, quantity, amount, price);
            TransactionDB.execute(query, goods_id, date, quantity, amount, price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTransaction() {
        // Update an existing transaction
        System.out.println("Enter transaction ID: ");
        int transId = Integer.parseInt(scanner.nextLine());
        System.out.print("Goods ID: ");
        int goods_id = Integer.parseInt(scanner.nextLine());
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Amount: ");
        int amount = Integer.parseInt(scanner.nextLine());
        Date date = new Date(currentTimeMillis());

        String query = "UPDATE transactions SET goods_id = ?, date = ?, quantity = ?, amount = ?, price = ? WHERE trans_id = ?;";
//        Transaction transaction = new Transaction(goods_id, date, quantity, amount, price);
//        transactions.add(transaction);
        try {
            // Call execute method with the transaction details
            TransactionDB.update(query, goods_id, date, quantity, amount, price, transId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteTransaction() {
        // Delete an existing transaction
        System.out.println("Enter transaction ID: ");
        int transId = Integer.parseInt(scanner.nextLine());

        String query = "DELETE FROM transactions WHERE trans_id = ?;";
        try {
            TransactionDB.delete(query, transId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getTransaction() {
        // Get a transaction
        System.out.print("Enter transaction ID: ");
        int transId = Integer.parseInt(scanner.nextLine());

        String query = "SELECT * FROM transactions WHERE trans_id = ?";

        try {
            TransactionDB.searchByTransId(query, transId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAllTransactions() {
        // Get all transactions
        String query = "SELECT * FROM transactions;";
        try {
            TransactionDB.search(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

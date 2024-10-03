package org.sep26.db;

import org.sep26.config.DBConnect;

import java.sql.*;

public class TransactionDB {

    public static void execute(String query, int goods_id, Date date, int quantity, int amount, double price) throws SQLException {
        DBConnect conndb = new DBConnect();
        Connection conn = conndb.connect();
        PreparedStatement stmt = conn.prepareStatement(query);

        try {
            stmt.setInt(1, goods_id);
            stmt.setDate(2, date);
            stmt.setInt(3, quantity);
            stmt.setInt(4, amount);
            stmt.setDouble(5, price);
            stmt.executeUpdate();
            System.out.println("Transaction added successfully");
        } catch (SQLException e) {
            System.err.println("Error while adding transaction: " + e.getMessage());
            throw e;
        } finally {
            stmt.close();
            conn.close();
        }
    }

    public static void search(String query) throws SQLException {
        DBConnect conndb = new DBConnect();
        Connection conn = conndb.connect();
        PreparedStatement stmt = conn.prepareStatement(query);

        try {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Transaction ID: " + rs.getInt("trans_id"));
                System.out.println("Goods ID: " + rs.getInt("goods_id"));
                System.out.println("Date: " + rs.getDate("date"));
                System.out.println("Price: " + rs.getDouble("price"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
                System.out.println("Amount: " + rs.getInt("amount"));

            }
        } catch (SQLException e) {
            System.err.println("Error while searching transaction: " + e.getMessage());
            throw e;
        } finally {
            stmt.close();
            conn.close();
        }
    }

    public static void searchByTransId(String query, int trans_id) throws SQLException {
        DBConnect conndb = new DBConnect();
        Connection conn = conndb.connect();
        PreparedStatement stmt = conn.prepareStatement(query);

        try {
            stmt.setInt(1, trans_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Transaction ID: " + rs.getInt("trans_id"));
                System.out.println("Goods ID: " + rs.getInt("goods_id"));
                System.out.println("Date: " + rs.getDate("date"));
                System.out.println("Price: " + rs.getDouble("price"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
                System.out.println("Amount: " + rs.getInt("amount"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(String query, int goods_id, Date date, int quantity, int amount, double price, int transId) throws SQLException {
        DBConnect conndb = new DBConnect();
        Connection conn = conndb.connect();
        PreparedStatement stmt = conn.prepareStatement(query);

        try {
            stmt.setInt(1, goods_id);
            stmt.setDate(2, date);
            stmt.setInt(3, quantity);
            stmt.setInt(4, amount);
            stmt.setDouble(5, price);
            stmt.setInt(6, transId);
            stmt.executeUpdate();
            System.out.println("Transaction updated successfully");
        } catch (SQLException e) {
            System.err.println("Error while updating transaction: " + e.getMessage());
            throw e;
        } finally {
            stmt.close();
            conn.close();
        }
    }

    public static void delete(String query, int trans_id) throws SQLException {
        DBConnect conndb = new DBConnect();
        Connection conn = conndb.connect();
        PreparedStatement stmt = conn.prepareStatement(query);

        try {
            stmt.setInt(1, trans_id);
            stmt.executeUpdate();
            System.out.println("Transaction deleted successfully");
        } catch (SQLException e) {
            System.err.println("Error while deleting transaction: " + e.getMessage());
            throw e;
        } finally {
            stmt.close();
            conn.close();
        }
    }
}

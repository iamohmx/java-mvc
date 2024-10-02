package org.sep26.db;

import org.sep26.config.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBExecute {

    public static void execute(String query, int plate, String model, String make) throws SQLException {
        DBConnect conndb = new DBConnect();
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
            throw e;
        }
    }

    public static void execute(String query, String model, String make, int plate) throws SQLException {
        DBConnect conndb = new DBConnect();
        Connection conn = conndb.connect();
        PreparedStatement stmt = conn.prepareStatement(query);

        try {
            stmt.setString(1, model);   // First placeholder for 'model'
            stmt.setString(2, make);    // Second placeholder for 'make'
            stmt.setInt(3, plate);      // Third placeholder for 'plate'
            stmt.executeUpdate();
            System.out.println("Car updated successfully");
        } catch (SQLException e) {
            System.err.println("Error while updating car: " + e.getMessage());
            throw e;
        } finally {
            stmt.close();
            conn.close();
        }
    }


    public static void execute(String query, int plate) throws SQLException {
        DBConnect conndb = new DBConnect();
        Connection conn = conndb.connect();
        PreparedStatement stmt = conn.prepareStatement(query);

        try {
            stmt.setInt(1, plate);
            stmt.executeUpdate();
            System.out.println("Car deleted successfully");
        } catch (SQLException e) {
            System.err.println("Error while deleting car: " + e.getMessage());
            throw e;
        }  finally {
            stmt.close();
            conn.close();
        }
    }

    public static void execute(String query) throws SQLException {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            DBConnect conndb = new DBConnect();
            conn = conndb.connect();
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Plate: " + rs.getInt("plate"));
                System.out.println("Model: " + rs.getString("model"));
                System.out.println("Make: " + rs.getString("make"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("Error while adding car: " + e.getMessage());
            throw e;
        } finally {
            stmt.close();
            conn.close();
        }
    }

    public static void execute(int plateOrId, String query) throws SQLException {
    DBConnect conndb = new DBConnect();
    Connection conn = conndb.connect();
    PreparedStatement stmt = conn.prepareStatement(query);

    try {
        stmt.setInt(1, plateOrId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.println("Plate: " + rs.getInt("plate"));
            System.out.println("Model: " + rs.getString("model"));
            System.out.println("Make: " + rs.getString("make"));
            System.out.println();
        }
    } catch (SQLException e) {
        System.err.println("Error while retrieving car: " + e.getMessage());
        throw e;
    } finally {
        stmt.close();
        conn.close();
    }
}


}

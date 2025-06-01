package com.affan.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
    private final String url = "jdbc:mysql://localhost:3306/bankmanagementsys";
    private final String name = "root";
    private final String password = "mit@12345";
    private Connection c;
    Statement s;

    public Conn() {
        try {
            // Load MySQL JDBC Driver (optional in newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            c = DriverManager.getConnection(url, name, password);
            s = c.createStatement();
            System.out.println("Database connected successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }

    // Getter method to access connection
    public Connection getConnection() {
        return c;
    }
}

package com.example.unit7.dao;

import com.example.unit7.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    // IMPORTANT: Update these connection details to match your MySQL setup
    private String jdbcURL = "jdbc:mysql://localhost:3306/javalab"; // e.g., javalab
    private String jdbcUsername = "root"; // e.g., root
    private String jdbcPassword = ""; // e.g., password

    public UserDAO() {
        try {
            // Ensure the JDBC driver is loaded. For MySQL Connector/J 8.x, this is typically not needed explicitly
            // but good practice for older versions or other databases.
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Make sure you have added mysql-connector-java.jar to your project's classpath.");
            e.printStackTrace();
        }
    }

    protected Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            System.err.println("Database connection failed. Check your JDBC URL, username, and password.");
            e.printStackTrace();
            throw e; // Re-throw to indicate connection failure
        }
        return connection;
    }

    public boolean validateUser(User user) {
        boolean status = false;
        String SQL_LOGIN = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_LOGIN)) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            System.out.println("Executing query: " + preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next(); // If a row is returned, user is valid

        } catch (SQLException e) {
            printSQLException(e);
        }
        return status;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.err.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

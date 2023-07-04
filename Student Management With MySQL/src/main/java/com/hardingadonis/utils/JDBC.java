package com.hardingadonis.utils;

import java.sql.*;

public class JDBC {

    private static String DB_URL = "jdbc:mysql://localhost:3306/management";
    private static String USER = "root";
    private static String PASSWORD = "";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            System.out.println("Connect MySQL successfully!");
        } catch (SQLException ex) {
            System.err.println("Connect MySQL failure!");
        }

        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
                
                System.out.println("Close MySQL successfully!");
            }
        } catch (SQLException ex) {
            System.err.println("Close MySQL failure!");
        }
    }
}

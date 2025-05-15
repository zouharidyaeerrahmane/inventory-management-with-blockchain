package com.app.inventoryblockchain.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                String url = ConfigLoader.get("database.url");
                String user = ConfigLoader.get("database.username");
                String password = ConfigLoader.get("database.password");

                connection = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException e) {
            throw new RuntimeException("connection error: ",e);
        }
        return connection;
    }
}

package com.app.inventoryblockchain.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class
DBInitializer {

    public static void initialize() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String userTable = """
                CREATE TABLE IF NOT EXISTS users (
                    id SERIAL PRIMARY KEY,
                    last_name VARCHAR(100) NOT NULL,
                    first_name VARCHAR(100) NOT NULL,
                    role VARCHAR(20) CHECK (role IN ('ADMIN', 'EMPLOYEE')) NOT NULL,
                    login VARCHAR(100) UNIQUE NOT NULL,
                    password VARCHAR(100) NOT NULL
                );
            """;

            String productTable = """
                CREATE TABLE IF NOT EXISTS products (
                    id SERIAL PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    quantity INTEGER NOT NULL,
                    threshold INTEGER NOT NULL,
                    price DOUBLE PRECISION NOT NULL
                );
            """;

            String transactionTable = """
                CREATE TABLE IF NOT EXISTS transactions (
                    id SERIAL PRIMARY KEY,
                    type VARCHAR(20) CHECK (type IN ('STOCK_IN', 'STOCK_OUT', 'TRANSFER')) NOT NULL,
                    date DATE NOT NULL,
                    quantity INTEGER NOT NULL,
                    previous_hash TEXT,
                    hash TEXT NOT NULL,
                    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                    product_id INTEGER REFERENCES products(id),
                    user_id INTEGER REFERENCES users(id)
                );
            """;

            stmt.execute(userTable);
            stmt.execute(productTable);
            stmt.execute(transactionTable);

            System.out.println("Database tables created successfully (if not already exist).");

        } catch (SQLException e) {
            throw  new RuntimeException("Error initializing database: " + e.getMessage());
        }
    }
}

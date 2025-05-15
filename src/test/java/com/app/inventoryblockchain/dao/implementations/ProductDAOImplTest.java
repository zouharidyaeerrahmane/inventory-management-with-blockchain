package com.app.inventoryblockchain.dao.implementations;

import com.app.inventoryblockchain.presentation.models.Product;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductDAOImplTest {
    private static Connection connection;
    private static ProductDAOImpl productDAO;

    @BeforeAll
    static void setupDatabase() throws SQLException {
        connection = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("""
                CREATE TABLE products (
                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(100),
                    price DOUBLE,
                    quantity INT,
                    threshold INT
                );
            """);
        }
        productDAO = new ProductDAOImpl(connection);
    }

    @AfterAll
    static void closeDatabase() throws SQLException {
        connection.close();
    }

    @BeforeEach
    void cleanTable() throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("DELETE FROM products");
        }
    }

    @Test
    void testSaveAndFindById() {
        Product product = new Product(1200.0, 3, 10, "laptop");
        boolean saved = productDAO.save(product);
        assertTrue(saved);

        List<Product> allProducts = productDAO.findAll();
        assertEquals(1, allProducts.size());

        Product retrieved = allProducts.get(0);
        Product found = productDAO.findById(retrieved.getId());
        assertNotNull(found);
        assertEquals("laptop", found.getName());
    }

    @Test
    void testUpdate() {
        Product product = new Product(800.0, 1, 5, "Phone");
        productDAO.save(product);
        Product saved = productDAO.findAll().get(0);

        saved.setPrice(850.0);
        saved.setQuantity(8);
        boolean updated = productDAO.update(saved);
        assertTrue(updated);

        Product updatedProduct = productDAO.findById(saved.getId());
        assertEquals(850.0, updatedProduct.getPrice());
        assertEquals(8, updatedProduct.getQuantity());
    }

    @Test
    void testDelete() {
        Product product = new Product(260.0, 2, 7, "Tablet");
        productDAO.save(product);
        long id = productDAO.findAll().get(0).getId();

        boolean deleted = productDAO.delete(id);
        assertTrue(deleted);
        assertNull(productDAO.findById(id));
    }

    @Test
    void testFindAll() {
        productDAO.save(new Product(260.0, 2, 7, "Tablet"));
        productDAO.save(new Product(1200.0, 3, 10, "laptop"));
        List<Product> products = productDAO.findAll();
        assertEquals(2, products.size());
    }
}

package com.app.inventoryblockchain.dao.implementations;



import com.app.inventoryblockchain.dao.interfaces.IUserDAO;
import com.app.inventoryblockchain.presentation.models.Role;
import com.app.inventoryblockchain.presentation.models.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserDAOImplTest {
    private static IUserDAO userDAO;
    private static Connection connection;

    @BeforeAll
    static void setUpDatabase()throws SQLException {
        connection = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("""
            CREATE TABLE users (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                first_name VARCHAR(100),
                last_name VARCHAR(100),
                role VARCHAR(50),
                login VARCHAR(100),
                password VARCHAR(255)
            );
        """);
        userDAO = new UserDAOImpl(connection);
    }

    @AfterAll
    static void tearDown() throws SQLException {
        connection.close();
    }

    @Test
    void testSaveAndFindById() {
        User user = new User("Doe", Role.ADMIN, "John", "johndoe", "pass123");
        boolean saved = userDAO.save(user);
        assertTrue(saved);
        assertTrue(user.getId() > 0);

        User found = userDAO.findById(user.getId());
        assertNotNull(found);
        assertEquals("Doe", found.getLastName());
    }

    @Test
    void testFindByLogin() {
        User user = new User("Smith", Role.EMPLOYEE, "Anna", "annasmith", "secret");
        userDAO.save(user);

        User found = userDAO.findByLogin("annasmith");
        assertNotNull(found);
        assertEquals("Anna", found.getFirstName());
    }

    @Test
    void testUpdate() {
        User user = new User("Black", Role.EMPLOYEE, "Jack", "jackblack", "oldpass");
        userDAO.save(user);
        user.setPassword("newpass");
        boolean updated = userDAO.update(user);
        assertTrue(updated);

        User updatedUser = userDAO.findById(user.getId());
        assertEquals("newpass", updatedUser.getPassword());
    }

    @Test
    void testDelete() {
        User user = new User("White", Role.ADMIN, "Walter", "walterwhite", "heisenberg");
        userDAO.save(user);
        boolean deleted = userDAO.delete(user.getId());
        assertTrue(deleted);
        assertNull(userDAO.findById(user.getId()));
    }

    @Test
    void testFindAll() {
        userDAO.save(new User("A", Role.EMPLOYEE, "A", "usera", "a"));
        userDAO.save(new User("B", Role.EMPLOYEE, "B", "userb", "b"));
        List<User> users = userDAO.findAll();
        assertTrue(users.size() >= 2);
    }
}

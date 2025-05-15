package com.app.inventoryblockchain.dao.implementations;
import com.app.inventoryblockchain.dao.interfaces.IProductDAO;
import com.app.inventoryblockchain.dao.interfaces.IUserDAO;
import com.app.inventoryblockchain.presentation.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.sql.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TransactionDAOImplTest {
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;
    @Mock
    private IUserDAO userDAO;
    @Mock
    private IProductDAO productDAO;

    @InjectMocks
    private TransactionDAOImpl transactionDAO;

    private Transaction transaction;
    private Product product;
    private User user;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        product = new Product();
        product.setId(1L);
        product.setName("Test Product");

        user = new User();
        user.setId(2L);

        transaction = new Transaction(
                0,
                Type.STOCK_IN,
                LocalDate.now(),
                product,
                10,
                "prevHash",
                "hash",
                new Timestamp(System.currentTimeMillis()),
                user
        );

        transactionDAO = new TransactionDAOImpl(connection, userDAO, productDAO);
    }

    @Test
    void testSave() throws Exception {
        String sql = "INSERT INTO transactions (type, date, product_id, quantity, previous_hash, hash, timestamp, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        when(connection.prepareStatement(sql)).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate()).thenReturn(1);

        boolean result = transactionDAO.save(transaction);
        assertTrue(result);

        verify(preparedStatement, times(1)).setString(1, "STOCK_IN");
        verify(preparedStatement, times(1)).setLong(3, product.getId());
        verify(preparedStatement, times(1)).setLong(8, user.getId());

    }

    @Test
    void testFindById() throws Exception {
        long id = 1L;
        String sql = "SELECT * FROM transactions WHERE id = ?";

        when(connection.prepareStatement(sql)).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true);

        when(resultSet.getLong("id")).thenReturn(id);
        when(resultSet.getString("type")).thenReturn("STOCK_IN");
        when(resultSet.getDate("date")).thenReturn(Date.valueOf(LocalDate.now()));
        when(resultSet.getInt("quantity")).thenReturn(10);
        when(resultSet.getString("previous_hash")).thenReturn("prevHash");
        when(resultSet.getString("hash")).thenReturn("hash");
        when(resultSet.getTimestamp("timestamp")).thenReturn(new Timestamp(System.currentTimeMillis()));
        when(resultSet.getLong("product_id")).thenReturn(1L);
        when(resultSet.getLong("user_id")).thenReturn(2L);

        when(productDAO.findById(1L)).thenReturn(product);
        when(userDAO.findById(2L)).thenReturn(user);

        Transaction found = transactionDAO.findById(id);
        assertNotNull(found);
        assertEquals("hash", found.getHash());
        assertEquals(10, found.getQuantity());
    }
}

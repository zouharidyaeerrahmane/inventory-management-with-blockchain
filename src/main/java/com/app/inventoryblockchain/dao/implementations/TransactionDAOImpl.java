package com.app.inventoryblockchain.dao.implementations;

import com.app.inventoryblockchain.dao.interfaces.IProductDAO;
import com.app.inventoryblockchain.dao.interfaces.ITransactionDAO;
import com.app.inventoryblockchain.dao.interfaces.IUserDAO;
import com.app.inventoryblockchain.presentation.models.Product;
import com.app.inventoryblockchain.presentation.models.Transaction;
import com.app.inventoryblockchain.presentation.models.Type;
import com.app.inventoryblockchain.presentation.models.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOImpl implements ITransactionDAO {
    private final Connection connection;
    private final IUserDAO userDAO;
    private final IProductDAO productDAO;

    public TransactionDAOImpl(Connection connection, IUserDAO userDAO, IProductDAO productDAO) {
        this.connection = connection;
        this.userDAO = userDAO;
        this.productDAO = productDAO;

    }

    @Override
    public boolean save(Transaction transaction) {
        String sql = "INSERT INTO transactions (type, date, product_id, quantity, previous_hash, hash, timestamp, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, transaction.getType().name());
            ps.setDate(2, Date.valueOf(transaction.getDate()));
            ps.setLong(3, transaction.getProduct().getId());
            ps.setInt(4, transaction.getQuantity());
            ps.setString(5, transaction.getPreviousHash());
            ps.setString(6, transaction.getHash());
            ps.setTimestamp(7, transaction.getTimestamp());
            ps.setLong(8, transaction.getUser().getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RuntimeException("Error saving transaction: " + e.getMessage(), e);
        }
    }

    @Override
    public Transaction findById(long id) {
        String sql = "SELECT * FROM transactions WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToTransaction(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error finding transaction: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Transaction> findAll() {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                transactions.add(mapResultSetToTransaction(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all transactions: " + e.getMessage(), e);
        }
        return transactions;
    }

    @Override
    public List<Transaction> findByProductId(long productId) {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE product_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, productId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    transactions.add(mapResultSetToTransaction(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding transactions by product ID: " + e.getMessage(), e);
        }
        return transactions;
    }

    @Override
    public List<Transaction> findByUserId(long userId) {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE user_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    transactions.add(mapResultSetToTransaction(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding transactions by user ID: " + e.getMessage(), e);
        }
        return transactions;
    }

    private Transaction mapResultSetToTransaction(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        Type type = Type.valueOf(rs.getString("type"));
        LocalDate date = rs.getDate("date").toLocalDate();
        int quantity = rs.getInt("quantity");
        String previousHash = rs.getString("previous_hash");
        String hash = rs.getString("hash");
        Timestamp timestamp = rs.getTimestamp("timestamp");

        long productId = rs.getLong("product_id");
        long userId = rs.getLong("user_id");

        Product product = productDAO.findById(productId);
        User user = userDAO.findById(userId);

        return new Transaction(id, type, date, product, quantity, previousHash, hash, timestamp, user);
    }

}

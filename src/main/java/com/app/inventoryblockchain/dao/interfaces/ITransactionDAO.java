package com.app.inventoryblockchain.dao.interfaces;

import com.app.inventoryblockchain.presentation.models.Transaction;

import java.util.List;

public interface ITransactionDAO {
    boolean save(Transaction transaction);
    Transaction findById(long id);
    List<Transaction> findAll();
    List<Transaction> findByProductId(long productId);
    List<Transaction> findByUserId(long userId);
}

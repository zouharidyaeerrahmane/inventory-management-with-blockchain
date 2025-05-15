package com.app.inventoryblockchain.dao.interfaces;

import com.app.inventoryblockchain.presentation.models.Product;

import java.util.List;

public interface IProductDAO {
    boolean save(Product product);
    boolean update(Product product);
    boolean delete(long id);
    Product findById(long id);
    List<Product> findAll();
} 
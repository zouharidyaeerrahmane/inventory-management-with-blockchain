package com.app.inventoryblockchain.business.services;

import com.app.inventoryblockchain.dao.implementations.ProductDAOImpl;
import com.app.inventoryblockchain.dao.interfaces.IProductDAO;
import com.app.inventoryblockchain.presentation.models.Product;

public class ProductService {
    private final IProductDAO productDAO = new ProductDAOImpl();

    //public Product addProduct(Product p)
    //public Product updateProduct(Product p)
    //getCriticalProducts()
    //findProduct(id)
} 
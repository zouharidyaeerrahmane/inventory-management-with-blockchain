package com.app.inventoryblockchain.mappers;

import com.app.inventoryblockchain.dto.ProductDTO;
import com.app.inventoryblockchain.presentation.models.Product;

public class ProductMapper {
    public static ProductDTO toDTO(Product product) {
        // Implementation details
        return new ProductDTO();
    }
    
    public static Product toEntity(ProductDTO productDTO) {
        // Implementation details
        return new Product();
    }
} 
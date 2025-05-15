package com.app.inventoryblockchain.mappers;

import com.app.inventoryblockchain.dto.UserDTO;
import com.app.inventoryblockchain.presentation.models.User;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        // Implementation details
        return new UserDTO();
    }
    
    public static User toEntity(UserDTO userDTO) {
        // Implementation details
        return new User();
    }
}
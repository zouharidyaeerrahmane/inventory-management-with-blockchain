package com.app.inventoryblockchain.utils;

import com.app.inventoryblockchain.presentation.models.User;

public class CurrentSession {
    private static User currentUser;

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void clear() {
        currentUser = null;
    }

    public static boolean isAdmin() {
        return currentUser != null && "ADMIN".equalsIgnoreCase(currentUser.getRole().name());
    }

    public static boolean isEmployee() {
        return currentUser != null && "EMPLOYEE".equalsIgnoreCase(currentUser.getRole().name());
    }
}

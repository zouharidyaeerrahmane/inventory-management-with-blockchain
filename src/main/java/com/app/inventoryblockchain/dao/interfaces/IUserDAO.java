package com.app.inventoryblockchain.dao.interfaces;

import com.app.inventoryblockchain.presentation.models.User;

import java.util.List;

public interface IUserDAO {
    boolean save(User user);
    boolean update(User user);
    boolean delete(long id);
    User findById(long id);
    User findByLogin(String login);
    List<User> findAll();
} 
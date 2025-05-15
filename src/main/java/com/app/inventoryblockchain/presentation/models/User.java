package com.app.inventoryblockchain.presentation.models;

public class User {
    private long id;
    private String lastName;
    private String firstName;
    private Role role;
    private String login;
    private String password;

    public User() {}

    public User(String lastName, Role role, String firstName, String login, String password) {
        this.lastName = lastName;
        this.id = 0;
        this.role = role;
        this.firstName = firstName;
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
} 
package com.app.inventoryblockchain.presentation.models;

public class Utilisateur {
    private long id;
    private String nom;
    private String prenom;
    private Role role;
    private String login;
    private String password;

    public Utilisateur() {}

    public Utilisateur(String nom, long id, Role role, String prenom, String login, String password) {
        this.nom = nom;
        this.id = id;
        this.role = role;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

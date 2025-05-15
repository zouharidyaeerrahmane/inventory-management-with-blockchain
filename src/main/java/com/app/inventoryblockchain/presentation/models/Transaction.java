package com.app.inventoryblockchain.presentation.models;


import java.time.LocalDate;

public class Transaction {
    private long id;
    private Type type;
    private LocalDate date;
    private Produit produit;
    private int quantite;
    private Utilisateur utilisateur;


    public Transaction() {}

    public Transaction(long id, Type type, LocalDate date, Produit produit, int quantite, Utilisateur utilisateur) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.produit = produit;
        this.quantite = quantite;
        this.utilisateur = utilisateur;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}

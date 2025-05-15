package com.app.inventoryblockchain.presentation.models;

public class Produit {
    private long id;
    private String nom;
    private int quantite;
    private int seuil;
    private double prix;

    public Produit() {

    }

    public Produit(long id, double prix, int seuil, int quantite, String nom) {
        this.id = id;
        this.prix = prix;
        this.seuil = seuil;
        this.quantite = quantite;
        this.nom = nom;
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

    public int getSeuil() {
        return seuil;
    }

    public void setSeuil(int seuil) {
        this.seuil = seuil;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}

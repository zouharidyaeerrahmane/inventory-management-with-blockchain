package com.app.inventoryblockchain.metier.services;

import com.app.inventoryblockchain.dao.implementations.ProduitDAOImpl;
import com.app.inventoryblockchain.dao.interfaces.IProduitDAO;
import com.app.inventoryblockchain.presentation.models.Produit;

public class ProduitService {
    private final IProduitDAO produitDAO = new ProduitDAOImpl();

    //public Produit Produit ajouterProduit(Produit p)
    //public  Produit modifierProduit(Produit p)
    //getProduitsCritiques()
    //rechercherProduit(id)

}

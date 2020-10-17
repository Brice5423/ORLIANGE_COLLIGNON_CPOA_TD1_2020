package DAO.Interfaces;

import java.util.List;

import Main.Metier.Produit;

// Interface DAO produit qui étend l'interface principale CRUD //
public interface IDaoProduit extends IDao<Produit> {
    // affiche la liste de tout les produit
    List<Produit> getAllProduits();
}

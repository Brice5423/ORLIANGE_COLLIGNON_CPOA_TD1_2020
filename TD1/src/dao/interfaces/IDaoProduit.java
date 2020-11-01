package dao.interfaces;


import java.util.List;

import home.metier.Categorie;
import home.metier.Produit;


// Interface DAO produit qui étend l'interface principale CRUD //
public interface IDaoProduit extends IDao<Produit> {
    // affiche la liste de tout les produit //
    List<Produit> getAllProduits();

    // affiche la liste en fonction d'un filtre //
    List<Produit> getByCategorie(Categorie filtreCategorie);
    List<Produit> getByNomProduit(String filtreNomProduit);
    List<Produit> getByTarif(Double filtreTarif);
}

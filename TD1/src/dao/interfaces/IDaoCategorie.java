package dao.interfaces;


import java.util.List;

import home.metier.Categorie;


public interface IDaoCategorie extends IDao<Categorie> {
    // affiche la liste de tout les categories //
    List<Categorie> getAllCategories();
}

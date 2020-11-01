package dao.interfaces;

import java.util.List;

import home.metier.Categorie;

public interface IDaoCategorie extends IDao<Categorie> {
    List<Categorie> getAllCategories();

    Categorie getByTitreCategorie(String titreCategorie);
}

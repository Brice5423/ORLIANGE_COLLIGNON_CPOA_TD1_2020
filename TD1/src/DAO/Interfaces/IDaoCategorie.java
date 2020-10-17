package DAO.Interfaces;

import java.util.List;

import Main.Metier.Categorie;

public interface IDaoCategorie extends IDao<Categorie> {
    List<Categorie> getAllCategories();
}

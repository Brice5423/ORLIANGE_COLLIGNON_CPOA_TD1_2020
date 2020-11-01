package dao.memoire;


import java.util.ArrayList;
import java.util.List;

import dao.interfaces.IDaoCategorie;
import home.metier.Categorie;


public class ListeMemoireCategorieDao implements IDaoCategorie {
    private static IDaoCategorie instance;
    private static List<Categorie> donnees;


    public static IDaoCategorie getInstance() {
        if (instance == null) {
            instance = new ListeMemoireCategorieDao();
        }
        return instance;
    }

    private ListeMemoireCategorieDao() {
        this.donnees = new ArrayList<Categorie>();
        this.donnees.add(new Categorie(1, "Matériel de PC", "pc.png"));
        this.donnees.add(new Categorie(2, "Pull", "pull.png"));
    }


    @Override
    public ArrayList<Categorie> getAllCategories() {
        return (ArrayList<Categorie>) this.donnees;
    }


    @Override // Create :
    public boolean create(Categorie objet) {
        if (donnees == null) {
            donnees = new ArrayList<>();
        }

        objet.setId(1);
        for (Categorie categorie : donnees) {
            if (categorie.getId() == objet.getId()) {
                objet.setId(objet.getId()+1);
            }
        }

        return this.donnees.add(objet);
    }

    @Override // Read :
    public Categorie getById(int id) {
        if (donnees != null && !donnees.isEmpty()) {
            // Itérator sur la liste des produits :
            for (Categorie categorie : donnees) {
                if (categorie.getId() == id) {
                    return categorie;
                }
            }
        }
        return null;
    }

    @Override // Update :
    public boolean update(Categorie objet) {
        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'une categorie inexistante");
        } else {
            this.donnees.set(idx, objet);
        }
        return true;
    }

    @Override
    public boolean delete(Categorie objet) {
        Categorie supprime;

        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de suppression d'une categorie inexistante");
        } else {
            supprime = this.donnees.remove(idx);
        }
        return objet.equals(supprime);
    }
}

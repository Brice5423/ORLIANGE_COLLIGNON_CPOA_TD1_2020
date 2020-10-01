/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   DAO            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package DAO.Memoire;

import java.util.ArrayList;
import java.util.List;

import DAO.Interfaces.IDaoCategorie;
import Metier.Categorie;

public class ListeMemoireCategorieDao implements IDaoCategorie {
    private static IDaoCategorie instance;
    private List<Categorie> donnees;

    public static IDaoCategorie getInstance() {
        if (instance == null) {
            instance = new ListeMemoireCategorieDao();
        }
        return instance;
    }

    private ListeMemoireCategorieDao() {
        this.donnees = new ArrayList<Categorie>();
        this.donnees.add(new Categorie(1, "Pulls", "pulls.png"));
        this.donnees.add(new Categorie(2, "Bonnets", "bonnets.png"));
    }


    @Override
    public ArrayList<Categorie> getAllCategories() {
        return (ArrayList<Categorie>) this.donnees;
    }


    @Override // Create :
    public boolean create(Categorie objet) {
        objet.setId(3);
        // Ne fonctionne que si l'objet métier est bien fait...
        while (this.donnees.contains(objet)) {
            objet.setId(objet.getId() + 1);
        }
        boolean ok = this.donnees.add(objet);
        return ok;
    }

    @Override // Read :
    public Categorie getById(int id) {
        // Ne fonctionne que si l'objet métier est bien fait...
        int idx = this.donnees.indexOf(new Categorie(id, "test", "test.png"));
        if (idx == -1) {
            throw new IllegalArgumentException("Aucune categorie ne possède cet identifiant");
        } else {
            return this.donnees.get(idx);
        }
    }

    @Override // Update :
    public boolean update(Categorie objet) {
        // Ne fonctionne que si l'objet métier est bien fait...
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
        // Ne fonctionne que si l'objet métier est bien fait...
        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de suppression d'une categorie inexistante");
        } else {
            supprime = this.donnees.remove(idx);
        }
        return objet.equals(supprime);
    }
}

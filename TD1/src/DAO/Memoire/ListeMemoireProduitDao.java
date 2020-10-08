/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   TD2 : DAO      */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package DAO.Memoire;

import java.util.ArrayList;
import java.util.List;

import DAO.Interfaces.IDaoProduit;
import Metier.Categorie;
import Metier.Produit;

public class ListeMemoireProduitDao implements IDaoProduit {
    private static IDaoProduit instance;
    private static List<Produit> donnees;

    // Création instance Singleton :
    public static IDaoProduit getInstance() {
        if (instance == null) {
            instance = new ListeMemoireProduitDao();
            createProduits();
        }
        return instance;
    }

    private ListeMemoireProduitDao() {
        // Pour éviter instanciation directe :
        this.donnees = new ArrayList<Produit>();
        this.donnees.add(new Produit(2, "Sonic te kiffe", "Inspiré par la saga Séga", 41.5, "pull.png", new Categorie()));
        this.donnees.add(new Produit(6, "La chaleur des rennes", "Classique mais efficace", 15.0, "bonnet0.png", new Categorie()));
        this.donnees.add(new Produit(12, "Dall", "Joyeux Noël avec nos petits lutins dansants !", 35.0, "bonnet1.png.png", new Categorie()));
    }


    private static List<Produit> createProduits() {
        if (donnees == null) {
            donnees = new ArrayList<>();
        }
        Categorie categorie = new Categorie(1, "Matériel de PC", "");
        // Création de deux produits :
        Produit produit1 = new Produit();
        produit1.setId(1);
        produit1.setNom("Souris");
        produit1.setDescription("C'est une souris de PC");
        produit1.setCategorie(categorie);
        produit1.setTarif(15.0d);
        donnees.add(produit1);

        Produit produit2 = new Produit();
        produit2.setId(3);
        produit2.setNom("Clavier");
        produit2.setDescription("C'est un clavier de PC");
        produit2.setCategorie(categorie);
        produit2.setTarif(20.0d);
        donnees.add(produit2);

        return donnees;
    }


    @Override
    public List<Produit> getAllProduits() {
        return (ArrayList<Produit>) this.donnees;
    }


    @Override // Create :
    public boolean create(Produit produit) {
        if (donnees == null) {
            donnees = new ArrayList<>();
        }
        return this.donnees.add(produit);
    }

    @Override // Read :
    public Produit getById(int id) {
        if (donnees != null && !donnees.isEmpty()) {
            // Itérator sur la liste des produits :
            for (Produit produit : donnees) {
                if (produit.getId() == id) {
                    return produit;
                }
            }
        }
        return null;
    }

    @Override // Update :
    public boolean update(Produit objet) {
        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'une categorie inexistante");
        } else {
            this.donnees.set(idx, objet);
        }
        return true;
    }

    @Override // Delete :
    public boolean delete(Produit objet) {
        Produit supprime;

        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de suppression d'une categorie inexistante");
        } else {
            supprime = this.donnees.remove(idx);
        }
        return objet.equals(supprime);
    }
}

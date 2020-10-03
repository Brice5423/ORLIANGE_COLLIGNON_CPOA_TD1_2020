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
    private static List<Produit> produits;

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
        this.produits = new ArrayList<Produit>();
        this.produits.add(new Produit(2, "Sonic te kiffe", "Inspiré par la saga Séga", 41.5, "pull.png", new Categorie()));
        this.produits.add(new Produit(6, "La chaleur des rennes", "Classique mais efficace", 15.0, "bonnet0.png", new Categorie()));
        this.produits.add(new Produit(12, "Dall", "Joyeux Noël avec nos petits lutins dansants !", 35.0, "bonnet1.png.png", new Categorie()));
    }


    @Override
    public List<Produit> getAllProduits() {
        return produits;
    }


    private static List<Produit> createProduits() {
        if (produits == null) {
            produits = new ArrayList<>();
        }
        Categorie categorie = new Categorie(1, "Matériel de PC", "");
        // Création de deux produits :
        Produit produit1 = new Produit();
        produit1.setId(1);
        produit1.setNom("Souris");
        produit1.setDescription("C'est une souris de PC");
        produit1.setCategorie(categorie);
        produit1.setTarif(15.0d);
        produits.add(produit1);

        Produit produit2 = new Produit();
        produit2.setId(1);
        produit2.setNom("Clavier");
        produit2.setDescription("C'est un clavier de PC");
        produit2.setCategorie(categorie);
        produit2.setTarif(20.0d);
        produits.add(produit2);
        return produits;
    }


    @Override // Create :
    public boolean create(Produit produit) {
        if (produits == null) {
            produits = new ArrayList<>();
        }
        return produits.add(produit);
    }

    @Override // Read :
    public Produit getById(int id) {
        if (produits != null && !produits.isEmpty()) {
            // Itérator sur la liste des produits :
            for (Produit produit : produits) {
                if (produit.getId() == id) {
                    return produit;
                }
            }
        }
        return null;
    }

    @Override // Update :
    public boolean update(Produit objet) {
        return false;
    }

    @Override // Delete :
    public boolean delete(Produit objet) {
        return false;
    }
}

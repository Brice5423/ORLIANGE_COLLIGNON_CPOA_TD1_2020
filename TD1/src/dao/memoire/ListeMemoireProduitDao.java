package dao.memoire;

import java.util.ArrayList;
import java.util.List;

import dao.interfaces.IDaoProduit;

import home.metier.Categorie;
import home.metier.Produit;

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
    }

    private static List<Produit> createProduits() {
        if (donnees == null) {
            donnees = new ArrayList<>();
        }

        Categorie categorie1 = new Categorie(1, "Matériel de PC", "pc.png");
        Categorie categorie2 = new Categorie(2, "Pull", "pull.png");

        // Création de deux produits :
        Produit produit1 = new Produit();
        produit1.setId(1);
        produit1.setNom("Souris");
        produit1.setDescription("C'est une souris de PC");
        produit1.setTarif(15.0);
        produit1.setVisuel("produit1.png");
        produit1.setCategorie(categorie1);
        donnees.add(produit1);

        Produit produit2 = new Produit();
        produit2.setId(2);
        produit2.setNom("Clavier");
        produit2.setDescription("C'est un clavier de PC");
        produit2.setTarif(20.0);
        produit2.setVisuel("produit2.png");
        produit2.setCategorie(categorie1);
        donnees.add(produit2);

        Produit produit3 = new Produit();
        produit3.setId(3);
        produit3.setNom("Kiki");
        produit3.setDescription("I love kiki !!!");
        produit3.setTarif(999.9);
        produit3.setVisuel("produit3.png");
        produit3.setCategorie(categorie2);
        donnees.add(produit3);

        return donnees;
    }


    @Override
    public List<Produit> getAllProduits() {
        return (ArrayList<Produit>) this.donnees;
    }


    @Override // Create :
    public boolean create(Produit objet) {
        if (donnees == null) {
            donnees = new ArrayList<>();
        }
        while (this.donnees.contains(objet)) {
            objet.setId(objet.getId() + 1);
        }
        return this.donnees.add(objet);
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
    public boolean update(Produit objet) { // marche juste avec une id
        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un produit inexistante");
        } else {
            this.donnees.set(idx, objet);
        }
        return true;
    }

    @Override // Delete :
    public boolean delete(Produit objet) { // marche bien avec id et entiere
        Produit supprime;

        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de suppression d'un produit inexistante");
        } else {
            supprime = this.donnees.remove(idx);
        }
        return objet.equals(supprime);
    }
}

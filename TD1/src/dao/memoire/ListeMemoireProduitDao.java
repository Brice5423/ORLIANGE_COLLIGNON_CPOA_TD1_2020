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
        Produit produit1 = new Produit(1, "Souris", "C'est une souris de PC", 15.0, "produit1.png", categorie1);
        donnees.add(produit1);
        Produit produit2 = new Produit(2, "Clavier", "C'est un clavier de PC", 20.0, "produit2.png", categorie1);
        donnees.add(produit2);
        Produit produit3 = new Produit(3, "Kiki", "I love kiki !!!", 999.9, "produit3.png", categorie2);
        donnees.add(produit3);

        return donnees;
    }


    @Override
    public List<Produit> getAllProduits() {
        return (ArrayList<Produit>) this.donnees;
    }

    @Override
    public List<Produit> getByCategorie(Categorie filtreCategorie) {
        List<Produit> listeFiltre;
        listeFiltre = new ArrayList<Produit>();

        for (Produit produit : donnees) {
            Categorie testCategorie = produit.getCategorie();
            if (testCategorie.getId() == filtreCategorie.getId()) {
                listeFiltre.add(produit);
            }
        }
        return listeFiltre;
    }

    @Override
    public List<Produit> getByNomProduit(String filtreNomProduit) {
        List<Produit> listeFiltre;
        listeFiltre = new ArrayList<Produit>();
        String filtreNomProduitLow = filtreNomProduit.toLowerCase();

        for (Produit produit : donnees) {
            String testNom = produit.getNom().toLowerCase();
            if (testNom == filtreNomProduitLow) {
                listeFiltre.add(produit);
            }
        }
        return listeFiltre;
    }

    @Override
    public List<Produit> getByTarif(Double filtreTarif) {
        List<Produit> listeFiltre;
        listeFiltre = new ArrayList<Produit>();

        for (Produit produit : donnees) {
            Double testTarif = produit.getTarif();
            if (testTarif <= filtreTarif) {
                listeFiltre.add(produit);
            }
        }
        return listeFiltre;
    }


    @Override // Create :
    public boolean create(Produit objet) {
        if (donnees == null) {
            donnees = new ArrayList<>();
        }

        objet.setId(1);
        for (Produit produit : donnees) {
            if (produit.getId() == objet.getId()) {
                objet.setId(objet.getId()+1);
            }
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

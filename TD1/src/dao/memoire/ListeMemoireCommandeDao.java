package dao.memoire;

import dao.interfaces.IDaoCommande;

import home.metier.Categorie;
import home.metier.Client;
import home.metier.Commande;
import home.metier.Produit;

import java.util.*;


public class ListeMemoireCommandeDao implements IDaoCommande {
    private static IDaoCommande instance;
    private static List<Commande> donnees;

    public static IDaoCommande getInstance() {
        if (instance == null) {
            instance = new ListeMemoireCommandeDao();
            createCommande();
        }
        return instance;
    }

    private ListeMemoireCommandeDao() {
        // Pour éviter instanciation directe :
        this.donnees = new ArrayList<Commande>();
    }

    private static List<Commande> createCommande() {
        if (donnees == null) {
            donnees = new ArrayList<>();
        }

        Date date = new Date();

        Client client1 = new Client(1, "ORLIANGE", "Brice");
        Client client2 = new Client(2, "COLLIGNON", "Nico");

        Categorie categorie1 = new Categorie(1, "Pull", "");
        Categorie categorie2 = new Categorie(2, "vest", "");

        Produit prodiot1 = new Produit(1, "Qiqi", "I love Qiqi", 9999.99, "", categorie1);
        Produit prodiot2 = new Produit(2, "DBZ", "Cool", 100., "", categorie1);
        Produit prodiot3 = new Produit(3, "Dall", "Joyeux Noel", 9.99, "", categorie2);

        Map<Produit, Integer> produits1 = new HashMap<>();
        produits1.put(prodiot1, 1);
        Map<Produit, Integer> produits2 = new HashMap<>();
        produits2.put(prodiot2, 5);
        produits2.put(prodiot3, 3);

        // Création de deux produits :
        Commande commande1 = new Commande();
        commande1.setId(1);
        commande1.setDate(date);
        commande1.setClient(client1);
        commande1.setProduits(produits1);
        donnees.add(commande1);

        Commande commande2 = new Commande();
        commande2.setId(2);
        commande2.setDate(date);
        commande2.setClient(client2);
        commande2.setProduits(produits2);
        donnees.add(commande2);

        return donnees;
    }


    @Override
    public List<Commande> getAllCommande() {
        return (ArrayList<Commande>) this.donnees;
    }

    @Override
    public boolean create(Commande objet) {
        /*if (donnees == null) {
            donnees = new ArrayList<>();
        }
        return this.donnees.add(produit);*/
        return false;
    }

    @Override
    public Commande getById(int id) {
        /*if (donnees != null && !donnees.isEmpty()) {
            // Itérator sur la liste des produits :
            for (Produit produit : donnees) {
                if (produit.getId() == id) {
                    return produit;
                }
            }
        }*/
        return null;
    }

    @Override
    public boolean update(Commande objet) {
        /*int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'un produit inexistante");
        } else {
            this.donnees.set(idx, objet);
        }
        return true;*/
        return false;
    }

    @Override
    public boolean delete(Commande objet) {
        /*Produit supprime;

        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de suppression d'un produit inexistante");
        } else {
            supprime = this.donnees.remove(idx);
        }
        return objet.equals(supprime);*/
        return false;
    }
}

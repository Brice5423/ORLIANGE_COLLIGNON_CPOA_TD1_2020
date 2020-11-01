package dao.memoire;

import dao.interfaces.IDaoCommande;

import home.metier.Categorie;
import home.metier.Client;
import home.metier.Commande;
import home.metier.Produit;

import java.time.LocalDateTime;
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

        Client client1 = new Client(1, "ORLIANGE", "Brice", "orl.bri@liste.com", "jetaime", "45", "rue", "54789", "cool", "happy");
        Client client2 = new Client(2, "COLLIGNON", "Nicolas", "col.nic@liste.com", "bisous", "36", "avenu", "57852", "nop", "hihi");

        Categorie categorie1 = new Categorie(1, "Matériel de PC", "pc.png");
        Categorie categorie2 = new Categorie(2, "Pull", "pull.png");

        Produit produit1 = new Produit(1, "Souris", "C'est une souris de PC", 15.0, "produit1.png", categorie1);
        Produit produit2 = new Produit(2, "Clavier", "C'est un clavier de PC", 20.0, "produit2.png", categorie1);
        Produit produit3 = new Produit(3, "Kiki", "I love kiki !!!", 999.9, "produit3.png", categorie2);

        Map<Produit, Integer> produits1 = new HashMap<>();
        produits1.put(produit1, 1);
        produits1.put(produit2, 1);
        Map<Produit, Integer> produits2 = new HashMap<>();
        produits2.put(produit2, 5);
        produits2.put(produit3, 3);

        // Création de deux commandes :
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
        if (donnees == null) {
            donnees = new ArrayList<>();
        }

        for (Commande commande : donnees) {
            if (commande.getId() == objet.getId()) {
                objet.setId(objet.getId()+1);
            }
        }
        return this.donnees.add(objet);
    }

    @Override
    public Commande getById(int id) {
        if (donnees != null && !donnees.isEmpty()) {
            // Itérator sur la liste des commandes :
            for (Commande commande : donnees) {
                if (commande.getId() == id) {
                    return commande;
                }
            }
        }
        return null;
    }

    @Override
    public boolean update(Commande objet) {
        int idx = this.donnees.indexOf(objet);
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de modification d'une commande inexistante");
        } else {
            this.donnees.set(idx, objet);
        }
        return true;
    }

    @Override
    public boolean delete(Commande objet) {
        int idx = this.donnees.indexOf(objet);
        Commande supprime;
        if (idx == -1) {
            throw new IllegalArgumentException("Tentative de suppression d'une commande inexistante");
        } else {
            supprime = this.donnees.remove(idx);
        }
        return objet.equals(supprime);
    }
}

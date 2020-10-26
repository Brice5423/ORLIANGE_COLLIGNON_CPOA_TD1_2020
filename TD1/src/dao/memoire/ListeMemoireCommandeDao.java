package dao.memoire;

import dao.interfaces.IDaoCommande;

import home.metier.Client;
import home.metier.Commande;
import home.metier.Produit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ListeMemoireCommandeDao implements IDaoCommande {
    private static IDaoCommande instance;
    private List<Commande> donnees;

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
        /*if (donnees == null) {
            donnees = new ArrayList<>();
        }

        Client client1 = new Client();
        Client client2 = new Client();

        Map<Produit, Integer> produits1;
        Map<Produit, Integer> produits2;

        // Création de deux produits :
        Commande commande1 = new Commande();
        commande1.setId(1);
        commande1.setDate();
        commande1.setClient(client1);
        commande1.setProduits(produits1);
        donnees.add(commande1);

        Commande commande2 = new Commande();
        commande2.setId(2);
        commande2.setDate();
        commande2.setClient(client2);
        commande2.setProduits(produits2);
        donnees.add(commande2);

        return donnees;*/
        return null;
    }


    @Override
    public List<Commande> getAllCommande() {
        return null;
    }

    @Override
    public boolean create(Commande objet) {
        return false;
    }

    @Override
    public Commande getById(int id) {
        return null;
    }

    @Override
    public boolean update(Commande objet) {
        return false;
    }

    @Override
    public boolean delete(Commande objet) {
        return false;
    }
}

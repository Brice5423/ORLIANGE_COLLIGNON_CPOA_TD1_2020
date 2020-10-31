package test.listememoire;

import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import dao.interfaces.IDaoCommande;

import home.metier.Commande;
import home.metier.Client;
import home.metier.Produit;
import home.metier.Categorie;

import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestListeMemoireCommande {
    private DaoFactory daoF;
    private IDaoCommande daoCommande;
    private List<Commande> listCommande;

    @Before
    public void setUp() {
        daoF = DaoFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
        daoCommande = daoF.getDaoCommande();
        listCommande = daoCommande.getAllCommande();
    }


    @Test
    public void testAllCommandes() {
        assertNotNull(listCommande);
    }

    @Test
    public void testCreate() {
        int size = listCommande.size();

        Client client = new Client();
        client.setId(23);
        Categorie categorie1 = new Categorie(1, "Pull", "");
        Produit prodiot1 = new Produit(1, "Qiqi", "I love Qiqi", 9999.99, "", categorie1);
        Produit prodiot2 = new Produit(2, "DBZ", "Cool", 100., "", categorie1);
        Map<Produit, Integer> produits = new HashMap<>();
        produits.put(prodiot1, 1);
        produits.put(prodiot2, 5);

        Commande commande = new Commande();
        commande.setDate(new Date());
        commande.setClient(client);
        commande.setProduits(produits);
        Assert.assertTrue(daoCommande.create(commande));

        assertEquals(size+1, daoCommande.getAllCommande().size());
    }

    @Test
    public void testGetById() {
        assertNotNull(daoCommande.getById(1));
    }

    @Test
    public void testUpdate() {
        Client client = new Client();
        client.setId(23);
        Categorie categorie1 = new Categorie(1, "Pull", "");
        Produit prodiot1 = new Produit(1, "Qiqi", "I love Qiqi", 9999.99, "", categorie1);
        Produit prodiot2 = new Produit(2, "DBZ", "Cool", 100., "", categorie1);
        Map<Produit, Integer> produits = new HashMap<>();
        produits.put(prodiot1, 1);
        produits.put(prodiot2, 5);

        Commande commande = new Commande();
        commande.setDate(new Date());
        commande.setClient(client);
        commande.setProduits(produits);
        assertTrue(daoCommande.create(commande));

        Commande commandeRead = commande;
        assertEquals(commande, commandeRead);

        Client clientRead = new Client();
        clientRead.setId(666);

        commandeRead.setClient(clientRead);
        assertTrue(daoCommande.update(commandeRead));
    }

    @Test
    public void testDelete() {
        Commande commande = daoCommande.getById(2);
        assertTrue(daoCommande.delete(commande));
    }
}

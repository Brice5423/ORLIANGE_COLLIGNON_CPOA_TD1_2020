package test.mysql;

import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import dao.interfaces.IDaoCommande;

import home.metier.Commande;
import home.metier.Client;
import home.metier.Produit;
import home.metier.Categorie;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMySQLCommande {
    private DaoFactory daoF;
    private IDaoCommande daoCommande;
    private List<Commande> liste;

    @Before
    public void setUp() {
        daoF = DaoFactory.getDAOFactory(EPersistance.MYSQL);
        daoCommande = daoF.getDaoCommande();
        liste = daoCommande.getAllCommande();
    }

    @Test
    public void testAllCommandes() {
        assertNotNull(liste);
    }

    @Test // Marche pas. La date fait de la merde ^^
    public void testCreate() {
        int size = daoCommande.getAllCommande().size();

        Client client = new Client();
        client.setId(1);
        Categorie categorie1 = new Categorie(1, "Pull", "");
        Produit prodiot1 = new Produit(1, "Qiqi", "I love Qiqi", 9999.99, "", categorie1);
        Produit prodiot2 = new Produit(2, "DBZ", "Cool", 100., "", categorie1);
        Map<Produit, Integer> produits = new HashMap<>();
        produits.put(prodiot1, 1);
        produits.put(prodiot2, 5);

        Commande commande = new Commande(1000, new Date(), client, produits);

        Assert.assertTrue(daoCommande.create(commande));
        assertEquals(size+1, daoCommande.getAllCommande().size());

        daoCommande.delete(commande);
    }

    @Test // Porblème inconu
    public void testGetById() {
        assertNotNull(daoCommande.getById(1));
    }

    @Test // Problème du à cree et modif commande
    public void testUpdate() {
        Client client = new Client();
        client.setId(23);
        Categorie categorie1 = new Categorie(1, "Pull", "");
        Produit prodiot1 = new Produit(1, "Qiqi", "I love Qiqi", 9999.99, "", categorie1);
        Produit prodiot2 = new Produit(2, "DBZ", "Cool", 100., "", categorie1);
        Map<Produit, Integer> produits = new HashMap<>();
        produits.put(prodiot1, 1);
        produits.put(prodiot2, 5);

        Commande commande = new Commande(1500, new Date(), client, produits);
        assertTrue(daoCommande.create(commande));

        Commande commandeRead = daoCommande.getById(1500);
        assertEquals(commande, commandeRead);

        Client clientRead = new Client();
        clientRead.setId(666);

        commandeRead.setClient(clientRead);
        assertTrue(daoCommande.update(commandeRead));

        assertEquals(commandeRead, daoCommande.getById(1500));

        daoCommande.delete(daoCommande.getById(1500));
    }

    @Test // Problème du à getById, problème incinu
    public void testDelete() {
        Commande copie = daoCommande.getById(1);

        Commande commande = daoCommande.getById(1);
        daoCommande.delete(commande);
        assertNull(daoCommande.delete(commande));

        daoCommande.create(copie);
    }
}

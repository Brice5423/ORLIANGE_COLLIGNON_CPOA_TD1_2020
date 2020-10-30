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
    private IDaoCommande dao;
    private List<Commande> liste;

    @Before
    public void setUp() {
        daoF = DaoFactory.getDAOFactory(EPersistance.MYSQL);
        dao = daoF.getDaoCommande();
        liste = dao.getAllCommande();
    }

    @Test
    public void testAllCommandes() {
        assertNotNull(liste);
    }

    @Test // Marche pas. La date fait de la merde ^^
    public void testCreate() {
        int size = dao.getAllCommande().size();

        Client client = new Client();
        client.setId(1);
        Categorie categorie1 = new Categorie(1, "Pull", "");
        Produit prodiot1 = new Produit(1, "Qiqi", "I love Qiqi", 9999.99, "", categorie1);
        Produit prodiot2 = new Produit(2, "DBZ", "Cool", 100., "", categorie1);
        Map<Produit, Integer> produits = new HashMap<>();
        produits.put(prodiot1, 1);
        produits.put(prodiot2, 5);

        Commande commande = new Commande(1000, new Date(), client, produits);

        Assert.assertTrue(dao.create(commande));
        assertEquals(size+1, dao.getAllCommande().size());

        dao.delete(commande);
    }

    @Test // Porblème inconu
    public void testGetById() {
        assertNotNull(dao.getById(1));
    }

    @Test // Problème du à cree et modif commande
    public void testUpdate() {
        Client client = new Client(4, "ORLIANGE", "Brice", "orl.brice@sql.com", "jetaime", "45", "rue", "54789", "cool", "happy");

        Categorie categorie = new Categorie(1, "Pulls", "lespulls.png");
        Produit prodiot1 = new Produit(19, "Qiqi", "Qiqi de genshin impact", 100000., "visuel.png", categorie);
        Produit prodiot2 = new Produit(16, "nomlol", "moche", 65., "pigon", categorie);
        Map<Produit, Integer> produits = new HashMap<>();
        produits.put(prodiot1, 1);
        produits.put(prodiot2, 5);

        Commande commande = new Commande(1500, new Date(), client, produits);
        assertTrue(dao.create(commande));

        Commande commandeRead = dao.getById(1500);
        assertEquals(commande, commandeRead);

        Client clientRead = client;
        clientRead.setNom("ORL");

        commandeRead.setClient(clientRead);
        assertTrue(dao.update(commandeRead));

        assertEquals(commandeRead, dao.getById(1500));

        dao.delete(dao.getById(1500));
    }

    @Test // Problème du à getById, problème incinu
    public void testDelete() {
        Commande copie = dao.getById(1);

        Commande commande = dao.getById(1);
        dao.delete(commande);
        assertNull(dao.getById(1));

        dao.create(copie);
    }
}

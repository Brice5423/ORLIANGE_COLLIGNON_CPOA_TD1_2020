package test.mysql;


import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import dao.interfaces.IDaoCommande;

import home.connexion.ConnexionSQL;
import home.metier.Commande;
import home.metier.Client;
import home.metier.Produit;
import home.metier.Categorie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestMySQLCommande {
    private Connection laConnexion;
    private DaoFactory daoF;
    private IDaoCommande dao;
    private List<Commande> liste;


    @Before
    public void setUp() {
        laConnexion = ConnexionSQL.creeConnexion();
        daoF = DaoFactory.getDAOFactory(EPersistance.MYSQL);
        dao = daoF.getDaoCommande();
        liste = dao.getAllCommande();
    }


    @Test
    public void testAllCommandes() {
        assertNotNull(liste);
    }


    @Test // Marche pas. La date fait de la merde ^^
    public void testCreate() throws SQLException {
        int size = dao.getAllCommande().size();
        int id;

        Client client = new Client(4, "ORLIANGE", "Brice", "orl.brice@sql.com", "jetaime", "45", "rue", "54789", "cool", "happy");
        Categorie categorie1 = new Categorie(1, "Pull", "pull.png");
        Produit prodiot1 = new Produit(1, "Qiqi", "I love Qiqi", 9999.99, "", categorie1);
        Produit prodiot2 = new Produit(2, "DBZ", "Cool", 100., "", categorie1);
        Map<Produit, Integer> produits = new HashMap<>();
        produits.put(prodiot1, 1);
        produits.put(prodiot2, 5);

        Commande commande = new Commande();
        commande.setDate(new Date());
        commande.setClient(client);
        commande.setProduits(produits);

        Assert.assertTrue(dao.create(commande));
        assertEquals(size+1, dao.getAllCommande().size());

        String request = "SELECT * FROM Commande";
        Statement statement = laConnexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(request);
        resultSet.last();
        id = resultSet.getInt("id_client");

        dao.delete(dao.getById(id));
    }

    @Test // Porblème inconu
    public void testGetById() {
        assertNotNull(dao.getById(1));
    }

    @Test // Problème du à cree et modif commande
    public void testUpdate() throws SQLException {
        int id;

        Client client = new Client(4, "ORLIANGE", "Brice", "orl.brice@sql.com", "jetaime", "45", "rue", "54789", "cool", "happy");
        Categorie categorie = new Categorie(1, "Pulls", "lespulls.png");
        Produit prodiot1 = new Produit(19, "Qiqi", "Qiqi de genshin impact", 100000., "visuel.png", categorie);
        Produit prodiot2 = new Produit(16, "nomlol", "moche", 65., "pigon", categorie);
        Map<Produit, Integer> produits = new HashMap<>();
        produits.put(prodiot1, 1);
        produits.put(prodiot2, 5);

        Commande commande = new Commande();
        commande.setDate(new Date());
        commande.setClient(client);
        commande.setProduits(produits);

        dao.create(commande);

        String request = "SELECT * FROM Commande";
        Statement statement = laConnexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(request);
        resultSet.last();
        id = resultSet.getInt("id_client");

        Commande commandeRead = dao.getById(id);
        assertEquals(commande, commandeRead);

        Client clientRead = client;
        clientRead.setNom("ORL");

        commandeRead.setClient(clientRead);
        assertTrue(dao.update(commandeRead));

        assertEquals(commandeRead, dao.getById(id));

        dao.delete(dao.getById(id));
    }

    @Test // Problème du à getById, problème incinu
    public void testDelete() throws SQLException {
        int id;

        Client client = new Client(4, "ORLIANGE", "Brice", "orl.brice@sql.com", "jetaime", "45", "rue", "54789", "cool", "happy");
        Categorie categorie = new Categorie(1, "Pulls", "lespulls.png");
        Produit prodiot1 = new Produit(19, "Qiqi", "Qiqi de genshin impact", 100000., "visuel.png", categorie);
        Produit prodiot2 = new Produit(16, "nomlol", "moche", 65., "pigon", categorie);
        Map<Produit, Integer> produits = new HashMap<>();
        produits.put(prodiot1, 1);
        produits.put(prodiot2, 5);

        Commande commande = new Commande();
        commande.setDate(new Date());
        commande.setClient(client);
        commande.setProduits(produits);

        dao.create(commande);

        String request = "SELECT * FROM Commande";
        Statement statement = laConnexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(request);
        resultSet.last();
        id = resultSet.getInt("id_client");

        dao.delete(commande);
        assertNull(dao.getById(id));
    }
}

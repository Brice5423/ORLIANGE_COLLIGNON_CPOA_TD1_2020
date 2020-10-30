package test.mysql;

import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import dao.interfaces.IDaoProduit;
import home.connexion.ConnexionSQL;
import home.metier.Produit;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TestMySQLProduit {
    private DaoFactory daoF;
    private IDaoProduit dao;
    private List<Produit> liste;
    private Connection laConnexion;

    @Before
    public void setUp() {
        daoF = DaoFactory.getDAOFactory(EPersistance.MYSQL);
        dao = daoF.getDaoProduit();
        liste = dao.getAllProduits();

        laConnexion = ConnexionSQL.creeConnexion();
    }


    @Test
    public void testAllProduits() {
        assertNotNull(liste);
    }

    @Test
    public void testCreate() throws SQLException {
        int size = dao.getAllProduits().size();
        int id;

        Produit produit = new Produit();
        produit.setId(100);
        produit.setNom("PC");
        produit.setDescription("C'est cool ma poule");

        Assert.assertTrue(dao.create(produit));
        assertEquals(size+1, dao.getAllProduits().size());

        String request = "SELECT * FROM Produit";
        Statement statement = laConnexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(request);
        resultSet.last();
        id = resultSet.getInt("id_client");

        dao.delete(dao.getById(id));
    }

    @Test
    public void testGetById() {
        assertNotNull(dao.getById(6));
    }

    @Test
    public void testUpdate() throws SQLException {
        int id;

        Produit produit = new Produit();
        produit.setId(150);
        produit.setNom("PC");
        produit.setDescription("C'est cool ma poule");

        dao.create(produit);

        String request = "SELECT * FROM Produit";
        Statement statement = laConnexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(request);
        resultSet.last();
        id = resultSet.getInt("id_client");

        Produit produitRead = dao.getById(id);
        assertEquals(produit, produitRead);

        produitRead.setNom("PC Gamer");
        assertTrue(dao.update(produitRead));

        assertEquals(produitRead, dao.getById(id));

        dao.delete(dao.getById(id));
    }

    @Test
    public void testDelete() throws SQLException {
        int id;

        Produit produit = new Produit();
        produit.setId(150);
        produit.setNom("PC");
        produit.setDescription("C'est cool ma poule");

        dao.create(produit);

        String request = "SELECT * FROM Produit";
        Statement statement = laConnexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(request);
        resultSet.last();
        id = resultSet.getInt("id_client");

        dao.delete(dao.getById(id));
        assertNull(dao.getById(id));
    }
}

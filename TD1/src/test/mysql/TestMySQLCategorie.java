package test.mysql;


import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import dao.interfaces.IDaoCategorie;

import home.connexion.ConnexionSQL;
import home.metier.Categorie;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class TestMySQLCategorie {
    private Connection laConnexion;
    private DaoFactory daoF;
    private IDaoCategorie dao;
    private List<Categorie> liste;


    @Before
    public void setUp() {
        laConnexion = ConnexionSQL.creeConnexion();
        daoF = DaoFactory.getDAOFactory(EPersistance.MYSQL);
        dao = daoF.getDaoCategorie();
        liste = dao.getAllCategories();
    }


    @Test
    public void testAllCategories() {
        assertNotNull(liste);
    }


    @Test
    public void testCreate() throws SQLException {
        int size = dao.getAllCategories().size();
        int id;

        Categorie categorie = new Categorie();
        categorie.setTitre("testCr");
        categorie.setVisuel("testCr.png");

        Assert.assertTrue(dao.create(categorie));
        assertEquals(size+1, dao.getAllCategories().size());

        String request = "SELECT * FROM Categorie";
        Statement statement = laConnexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(request);
        resultSet.last();
        id = resultSet.getInt("id_client");

        dao.delete(dao.getById(id));
    }

    @Test
    public void testGetById() {
        assertNotNull(dao.getById(1));
    }

    @Test
    public void testUpdate() throws SQLException {
        int id;

        Categorie categorie = new Categorie();
        categorie.setTitre("testUp");
        categorie.setVisuel("testUp.png");

        dao.create(categorie);

        String request = "SELECT * FROM Categorie";
        Statement statement = laConnexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(request);
        resultSet.last();
        id = resultSet.getInt("id_client");

        Categorie categorieRead = dao.getById(id);
        assertEquals(categorie, categorieRead);

        categorieRead.setTitre("testUpModif");
        assertTrue(dao.update(categorieRead));

        assertEquals(categorieRead, dao.getById(id));

        dao.delete(dao.getById(id));
    }

    @Test
    public void testDelete() throws SQLException {
        int id;

        Categorie categorie = new Categorie();
        categorie.setTitre("testDe !");
        categorie.setVisuel("testDe.png");

        dao.create(categorie);

        String request = "SELECT * FROM Categorie";
        Statement statement = laConnexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(request);
        resultSet.last();
        id = resultSet.getInt("id_client");

        dao.delete(dao.getById(id));
        assertNull(dao.getById(id));
    }
}

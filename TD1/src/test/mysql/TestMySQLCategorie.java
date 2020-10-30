package test.mysql;

import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import dao.interfaces.IDaoCategorie;
import home.metier.Categorie;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class TestMySQLCategorie {
    private DaoFactory daoF;
    private IDaoCategorie dao;
    private List<Categorie> liste;

    @Before
    public void setUp() {
        daoF = DaoFactory.getDAOFactory(EPersistance.MYSQL);
        dao = daoF.getDaoCategorie();
        liste = dao.getAllCategories();
    }


    @Test
    public void testAllCategories() {
        assertNotNull(liste);
    }

    @Test
    public void testCreate() {
        int size = dao.getAllCategories().size();

        Categorie categorie = new Categorie();
        categorie.setId(100);
        categorie.setTitre("banana !");
        categorie.setVisuel("banana.png");
        Assert.assertTrue(dao.create(categorie));

        assertEquals(size+1, dao.getAllCategories().size());

        dao.delete(categorie);
    }

    @Test
    public void testGetById() {
        assertNotNull(dao.getById(1));
    }

    @Test
    public void testUpdate() {
        Categorie categorie = new Categorie();
        categorie.setId(150);
        categorie.setTitre("banana !");
        categorie.setVisuel("banana.png");

        assertTrue(dao.create(categorie));

        Categorie categorieRead = dao.getById(150);
        assertEquals(categorie, categorieRead);

        categorieRead.setTitre("banane au chocolat");
        assertTrue(dao.update(categorieRead));

        assertEquals(categorieRead, dao.getById(150));

        dao.delete(dao.getById(150));
    }

    @Test
    public void testDelete() {
        Categorie copie = dao.getById(1);

        Categorie categorie = dao.getById(2);
        dao.delete(categorie);
        assertNull(dao.getById(2));

        dao.create(copie);
    }
}

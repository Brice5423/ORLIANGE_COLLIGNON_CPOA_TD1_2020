package test.listememoire;


import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import dao.interfaces.IDaoCategorie;

import home.metier.Categorie;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class TestListeMemoireCategorie {
    private DaoFactory daoF;
    private IDaoCategorie dao;
    private List<Categorie> liste;


    @Before
    public void setUp() {
        daoF = DaoFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
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
        categorie.setTitre("testCr");
        categorie.setVisuel("testCr.png");
        Assert.assertTrue(dao.create(categorie));

        assertEquals(size+1, dao.getAllCategories().size());
    }

    @Test
    public void testGetById() {
        assertNotNull(dao.getById(1));
    }

    @Test
    public void testUpdate() {
        Categorie categorie = new Categorie();
        categorie.setTitre("testUp");
        categorie.setVisuel("testUp.png");

        assertTrue(dao.create(categorie));

        Categorie categorieRead = categorie;
        assertEquals(categorie, categorieRead);

        categorieRead.setTitre("testUpModif");
        assertTrue(dao.update(categorieRead));
    }

    @Test
    public void testDelete() {
        Categorie categorie = dao.getById(2);
        assertTrue(dao.delete(categorie));
        //assertNull(dao.getById(2));
    }
}

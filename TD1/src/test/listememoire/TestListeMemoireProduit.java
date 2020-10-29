package test.listememoire;

import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import dao.interfaces.IDaoProduit;
import home.metier.Produit;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class TestListeMemoireProduit {
    private DaoFactory daoF;
    private IDaoProduit dao;
    private List<Produit> liste;

    @Before
    public void setUp() {
        daoF = DaoFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
        dao = daoF.getDaoProduit();
        liste = dao.getAllProduits();
    }


    @Test
    public void testAllProduits() {
        assertNotNull(liste);
    }

    @Test
    public void testCreate() {
        int size = dao.getAllProduits().size();

        Produit produit = new Produit();
        produit.setId(1);
        produit.setNom("PC");
        produit.setDescription("C'est cool ma poule");
        Assert.assertTrue(dao.create(produit));

        assertEquals(size+1, dao.getAllProduits().size());
    }

    @Test
    public void testGetById() {
        assertNotNull(dao.getById(1));
    }

    @Test
    public void testUpdate() {
        Produit produit = new Produit();
        produit.setId(4);
        produit.setNom("PC");
        produit.setDescription("C'est cool ma poule");

        assertTrue(dao.create(produit));

        Produit produitRead = dao.getById(4);
        assertEquals(produit, produitRead);

        produitRead.setNom("PC Gamer");
        assertTrue(dao.update(produitRead));

        assertEquals(produitRead, dao.getById(4));
    }

    @Test
    public void testDelete() {
        Produit produit = dao.getById(2);
        dao.delete(produit);
        assertNull(dao.getById(2));
    }
}

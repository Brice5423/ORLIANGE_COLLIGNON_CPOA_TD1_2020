package test.mysql;

import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import dao.interfaces.IDaoProduit;
import home.metier.Produit;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class TestMySQLProduit {
    private DaoFactory DaoF;
    private IDaoProduit Dao;
    private List<Produit> Liste;

    @Before
    public void setUp() {
        DaoF = DaoFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
        Dao = DaoF.getDaoProduit();
        Liste = Dao.getAllProduits();
    }


    @Test
    public void testAllProduits() {
        assertNotNull(Liste);
    }

    @Test
    public void testCreate() {
        int size = Dao.getAllProduits().size();

        Produit produit = new Produit();
        produit.setId(100);
        produit.setNom("PC");
        produit.setDescription("C'est cool ma poule");
        Assert.assertTrue(Dao.create(produit));

        assertEquals(size+1, Dao.getAllProduits().size());

        Dao.delete(produit);
    }

    @Test
    public void testGetById() {
        assertNotNull(Dao.getById(1));
    }

    @Test
    public void testUpdate() {
        Produit produit = new Produit();
        produit.setId(150);
        produit.setNom("PC");
        produit.setDescription("C'est cool ma poule");

        assertTrue(Dao.create(produit));

        Produit produitRead = Dao.getById(150);
        assertEquals(produit, produitRead);

        produitRead.setNom("PC Gamer");
        assertTrue(Dao.update(produitRead));

        assertEquals(produitRead, Dao.getById(150));

        Dao.delete(Dao.getById(150));
    }

    @Test
    public void testDelete() {
        Produit copie = Dao.getById(2);

        Produit produit = Dao.getById(2);
        Dao.delete(produit);
        assertNull(Dao.getById(2));

        Dao.create(copie);
    }
}

package test.listememoire;

import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import dao.interfaces.IDaoProduit;
import home.metier.Categorie;
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
        produit.setNom("testCr");
        produit.setDescription("testCr");
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
        produit.setNom("testUp");
        produit.setDescription("testUp");

        assertTrue(dao.create(produit));

        Produit produitRead = produit;
        assertEquals(produit, produitRead);

        produitRead.setNom("testUpModif");
        assertTrue(dao.update(produitRead));
    }

    @Test
    public void testDelete() {
        Produit produit = dao.getById(2);
        assertTrue(dao.delete(produit));
    }


    @Test
    public void testFiltreCategorie() {
        Categorie categorie = new Categorie(1, "Pull", "pull.png");

        assertNotNull(dao.getByCategorie(categorie));

        assertEquals(dao.getByCategorie(categorie).size(), 2);
    }

    @Test
    public void testFiltreNomProduit() {
        assertNotNull(dao.getByNomProduit("Kiki"));
        assertNotNull(dao.getByNomProduit("kiki"));
    }

    @Test
    public void testFiltreTarif() {
        assertNotNull(dao.getByTarif(36.));

        assertEquals(dao.getByTarif(36.).size(), 2);
    }
}

/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   Test           */
/* Langage : Java & SQL           |                  */
/* Date : 09/10/2020              |                  */
/*****************************************************/

package Test.MySQL;

import DAO.Enum.EPersistance;
import DAO.Factory.DaoFactory;
import DAO.Interfaces.IDaoCategorie;
import Main.Metier.Categorie;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class TestMySQLCategorie {
    private DaoFactory DaoF;
    private IDaoCategorie Dao;
    private List<Categorie> Liste;

    @Before
    public void setUp() {
        DaoF = DaoFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
        Dao = DaoF.getDaoCategorie();
        Liste = Dao.getAllCategories();
    }


    @Test
    public void testAllCategories() {
        assertNotNull(Liste);
    }

    @Test
    public void testCreate() {
        int size = Dao.getAllCategories().size();

        Categorie categorie = new Categorie();
        categorie.setId(100);
        categorie.setTitre("banana !");
        categorie.setVisuel("banana.png");
        Assert.assertTrue(Dao.create(categorie));

        assertEquals(size+1, Dao.getAllCategories().size());

        Dao.delete(categorie);
    }

    @Test
    public void testGetById() {
        assertNotNull(Dao.getById(1));
    }

    @Test
    public void testUpdate() {
        Categorie categorie = new Categorie();
        categorie.setId(150);
        categorie.setTitre("banana !");
        categorie.setVisuel("banana.png");

        assertTrue(Dao.create(categorie));

        Categorie categorieRead = Dao.getById(150);
        assertEquals(categorie, categorieRead);

        categorieRead.setTitre("banane au chocolat");
        assertTrue(Dao.update(categorieRead));

        assertEquals(categorieRead, Dao.getById(150));

        Dao.delete(Dao.getById(150));
    }

    @Test
    public void testDelete() {
        Categorie copie = Dao.getById(1);

        Categorie categorie = Dao.getById(2);
        Dao.delete(categorie);
        assertNull(Dao.getById(2));

        Dao.create(copie);
    }
}

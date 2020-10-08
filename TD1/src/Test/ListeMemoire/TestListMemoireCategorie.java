package Test.ListeMemoire;

import org.junit.Before;
import org.junit.Test;
import java.util.List;

import Metier.Categorie;
import DAO.Enum.EPersistance;
import DAO.Factory.DaoFactory;
import DAO.Interfaces.IDaoCategorie;
import DAO.Memoire.ListeMemoireCategorieDao;

import static org.junit.Assert.assertNotNull;

public class TestListMemoireCategorie {
    private DaoFactory DaoF;
    private IDaoCategorie DaoCat;
    private List<Categorie> ListCategorie;

    @Before
    public void setUp() {
        DaoF = DaoFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
        DaoCat = DaoF.getDaoCategorie();
        ListCategorie = DaoCat.getAllCategories();
    }


    @Test
    public void testArrayList() {
        assertNotNull(ListCategorie);
    }

    @Test
    private void testCreate() {
        Categorie categorie = new Categorie();
        categorie.setId(1);
        categorie.setTitre("banana !");
        categorie.setVisuel("banana.png");

        assertNotNull(DaoCat.create(categorie));
    }
}

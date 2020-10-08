package Test.ListeMemoire;

import org.junit.Before;
import org.junit.Test;

import DAO.Enum.EPersistance;
import DAO.Factory.DaoFactory;
import DAO.Interfaces.IDaoProduit;
import DAO.Memoire.ListeMemoireProduitDao;

public class TestListMemoireProduit {
    @Before
    public void setUp() {
        DaoFactory DaoF = DaoFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
    }

    @Test
    public void test() {

    }
}

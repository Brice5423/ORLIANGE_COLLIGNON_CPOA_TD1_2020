package Test.ListeMemoire;

import org.junit.Before;
import org.junit.Test;

import DAO.Enum.EPersistance;
import DAO.Factory.DaoFactory;
import DAO.Interfaces.IDaoClient;
import DAO.Memoire.ListeMemoireClientDao;

public class TestListMemoireClient {
    @Before
    public void setUp() {
        DaoFactory DaoF = DaoFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
    }

    @Test
    public void test() {

    }
}

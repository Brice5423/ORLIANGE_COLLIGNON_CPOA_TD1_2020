package Test.MySQL;

import org.junit.Before;
import org.junit.Test;

import DAO.Enum.EPersistance;
import DAO.Factory.DaoFactory;
import DAO.Interfaces.IDaoProduit;
import DAO.Memoire.MySqlProduitDao;

public class TestMySQLProduit {
    @Before
    public void setUp() {
        DaoFactory DaoF = DaoFactory.getDAOFactory(EPersistance.MYSQL);
    }

    @Test
    public void test() {

    }
}

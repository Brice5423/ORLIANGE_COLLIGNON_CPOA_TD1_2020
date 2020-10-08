package Test.MySQL;

import org.junit.Before;
import org.junit.Test;

import DAO.Enum.EPersistance;
import DAO.Factory.DaoFactory;
import DAO.Interfaces.IDaoCategorie;
import DAO.Memoire.MySqlCategorieDao;

public class TestMySQLCategorie {
    @Before
    public void setUp() {
        DaoFactory DaoF = DaoFactory.getDAOFactory(EPersistance.MYSQL);
    }

    @Test
    public void test() {

    }
}

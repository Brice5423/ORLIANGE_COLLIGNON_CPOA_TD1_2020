package Test.MySQL;

import org.junit.Before;
import org.junit.Test;

import DAO.Enum.EPersistance;
import DAO.Factory.DaoFactory;
import DAO.Interfaces.IDaoClient;
import DAO.Memoire.MySqlClientDao;

public class TestMySQLClient {
    @Before
    public void setUp() {
        DaoFactory DaoF = DaoFactory.getDAOFactory(EPersistance.MYSQL);
    }

    @Test
    public void test() {

    }
}

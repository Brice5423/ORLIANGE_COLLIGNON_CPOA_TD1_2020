package Test.MySQL;

import DAO.Enum.EPersistance;
import DAO.Factory.DaoFactory;
import DAO.Interfaces.IDaoClient;
import Metier.Client;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class TestMySQLClient {
    private DaoFactory DaoF;
    private IDaoClient Dao;
    private List<Client> Liste;

    @Before
    public void setUp() {
        DaoF = DaoFactory.getDAOFactory(EPersistance.MYSQL);
        Dao = DaoF.getDaoClient();
        Liste = Dao.getAllClients();
    }


    @Test
    public void testGetAllClient() {
        assertNotNull(Liste);
    }

    @Test
    public void testCreate() {

    }

    @Test
    public void testGetById() {

    }

    @Test
    public void testUpdate() {

    }

    @Test
    public void testDelete() {

    }
}

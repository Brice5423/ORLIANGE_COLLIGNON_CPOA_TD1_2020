package test.mysql;

import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import dao.interfaces.IDaoClient;
import home.metier.Client;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class TestMySQLClient {
    private DaoFactory daoF;
    private IDaoClient dao;
    private List<Client> liste;

    @Before
    public void setUp() {
        daoF = DaoFactory.getDAOFactory(EPersistance.MYSQL);
        dao = daoF.getDaoClient();
        liste = dao.getAllClients();
    }


    @Test
    public void testAllClients() {
        assertNotNull(liste);
    }

    @Test
    public void testCreate() {
        int size = dao.getAllClients().size();

        Client client = new Client();
        client.setNom("Test");
        client.setPrenom("test");
        client.setMail("test@test.com");
        client.setMdp("test");
        client.setAdresse("02", "rue test", "99666", "test", "test");

        Assert.assertTrue(dao.create(client));
        assertEquals(size+1, dao.getAllClients().size());

        dao.delete(client);
    }

    @Test
    public void testGetById() {
        assertNotNull(dao.getById(2));
    }

    @Test
    public void testUpdate() {
        Client client = new Client();
        client.setNom("Test");
        client.setPrenom("test");
        client.setMail("test@test.com");
        client.setMdp("test");
        client.setAdresse("02", "rue test", "99666", "test", "test");

        assertTrue(dao.create(client));

        Client clientRead = dao.getById(150);
        assertEquals(client, clientRead);

        clientRead.setNom("BriceBricou");
        assertTrue(dao.update(clientRead));

        assertEquals(clientRead, dao.getById(150));

        dao.delete(dao.getById(150));
    }

    @Test
    public void testDelete() {
        Client copie = dao.getById(4);

        Client client = dao.getById(4);
        dao.delete(client);
        assertNull(dao.getById(4));

        dao.create(copie);
    }
}

package test.listememoire;

import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import dao.interfaces.IDaoClient;
import home.metier.Client;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class TestListeMemoireClient {
    private DaoFactory daoF;
    private IDaoClient dao;
    private List<Client> liste;

    @Before
    public void setUp() {
        daoF = DaoFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
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
        client.setNom("testCr");
        client.setPrenom("testCr");
        client.setMail("testCr@test.com");
        client.setMdp("testCr");
        client.setAdresse("02", "rue testCr", "99666", "testCr", "testCr");

        Assert.assertTrue(dao.create(client));
        assertEquals(size+1, dao.getAllClients().size());
    }

    @Test
    public void testGetById() {
        assertNotNull(dao.getById(1));
    }

    @Test
    public void testUpdate() {
        Client client = new Client();
        client.setNom("testUp");
        client.setPrenom("testUp");
        client.setMail("testUp@test.com");
        client.setMdp("testUp");
        client.setAdresse("02", "rue testUp", "99666", "testUp", "testUp");

        assertTrue(dao.create(client));

        Client clientRead = client;
        assertEquals(client, clientRead);

        clientRead.setNom("testUpModif");
        assertTrue(dao.update(clientRead));
    }

    @Test
    public void testDelete() {
        Client client = dao.getById(2);
        assertTrue(dao.delete(client));
    }
}

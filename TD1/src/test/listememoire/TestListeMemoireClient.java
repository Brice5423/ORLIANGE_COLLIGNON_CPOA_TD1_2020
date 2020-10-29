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
        client.setId(1);
        client.setNom("Bricou");
        client.setPrenom("Brice");
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
        client.setId(4);
        client.setNom("Bricou");
        client.setPrenom("Brice");

        assertTrue(dao.create(client));

        Client clientRead = dao.getById(4);
        assertEquals(client, clientRead);

        clientRead.setNom("BriceBricou");
        assertTrue(dao.update(clientRead));

        assertEquals(clientRead, dao.getById(4));
    }

    @Test
    public void testDelete() {
        Client client = dao.getById(2);
        dao.delete(client);
        assertNull(dao.getById(2));
    }
}

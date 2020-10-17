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
    private DaoFactory DaoF;
    private IDaoClient Dao;
    private List<Client> Liste;

    @Before
    public void setUp() {
        DaoF = DaoFactory.getDAOFactory(EPersistance.LISTE_MEMOIRE);
        Dao = DaoF.getDaoClient();
        Liste = Dao.getAllClients();
    }


    @Test
    public void testAllClients() {
        assertNotNull(Liste);
    }

    @Test
    public void testCreate() {
        int size = Dao.getAllClients().size();

        Client client = new Client();
        client.setId(100);
        client.setNom("Bricou");
        client.setPrenom("Brice");
        Assert.assertTrue(Dao.create(client));

        assertEquals(size+1, Dao.getAllClients().size());

        Dao.delete(client);
    }

    @Test
    public void testGetById() {
        assertNotNull(Dao.getById(1));
    }

    @Test
    public void testUpdate() {
        Client client = new Client();
        client.setId(150);
        client.setNom("Bricou");
        client.setPrenom("Brice");

        assertTrue(Dao.create(client));

        Client clientRead = Dao.getById(150);
        assertEquals(client, clientRead);

        clientRead.setNom("BriceBricou");
        assertTrue(Dao.update(clientRead));

        assertEquals(clientRead, Dao.getById(150));

        Dao.delete(Dao.getById(150));
    }

    @Test
    public void testDelete() {
        Client copie = Dao.getById(1);

        Client client = Dao.getById(1);
        Dao.delete(client);
        assertNull(Dao.getById(1));

        Dao.create(copie);
    }
}

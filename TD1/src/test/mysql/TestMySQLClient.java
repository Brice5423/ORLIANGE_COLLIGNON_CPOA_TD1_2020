package test.mysql;

import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import dao.interfaces.IDaoClient;
import home.connexion.ConnexionSQL;
import home.metier.Client;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TestMySQLClient {
    private Connection laConnexion;
    private DaoFactory daoF;
    private IDaoClient dao;
    private List<Client> liste;

    @Before
    public void setUp() {
        laConnexion = ConnexionSQL.creeConnexion();
        daoF = DaoFactory.getDAOFactory(EPersistance.MYSQL);
        dao = daoF.getDaoClient();
        liste = dao.getAllClients();
    }


    @Test
    public void testAllClients() {
        assertNotNull(liste);
    }

    @Test
    public void testCreate() throws SQLException {
        int size = dao.getAllClients().size();
        int id;

        Client client = new Client();
        client.setNom("TestCr");
        client.setPrenom("testCr");
        client.setMail("testCr@test.com");
        client.setMdp("testCr");
        client.setAdresse("02", "rue testCr", "99666", "testCr", "testCr");

        Assert.assertTrue(dao.create(client));
        assertEquals(size+1, dao.getAllClients().size());

        String request = "SELECT * FROM Client";
        Statement statement = laConnexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(request);
        resultSet.last();
        id = resultSet.getInt("id_client");

        dao.delete(dao.getById(id));
    }

    @Test
    public void testGetById() {
        assertNotNull(dao.getById(2));
    }

    @Test
    public void testUpdate() throws SQLException {
        int id;

        Client client = new Client();
        client.setNom("TestUp");
        client.setPrenom("testUp");
        client.setMail("testUp@test.com");
        client.setMdp("testUp");
        client.setAdresse("02", "rue testUp", "99666", "testUp", "testUp");

        dao.create(client);

        String request = "SELECT * FROM Client";
        Statement statement = laConnexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(request);
        resultSet.last();
        id = resultSet.getInt("id_client");

        Client clientRead = dao.getById(id);
        assertEquals(client, clientRead);

        clientRead.setNom("TestUpModif");
        assertTrue(dao.update(clientRead));

        assertEquals(clientRead, dao.getById(id));

        dao.delete(dao.getById(id));
    }

    @Test
    public void testDelete() throws SQLException {
        int id;

        Client client = new Client();
        client.setNom("TestDe");
        client.setPrenom("testDe");
        client.setMail("testDe@test.com");
        client.setMdp("testDe");
        client.setAdresse("02", "rue testDe", "99666", "testDe", "testDe");

        dao.create(client);

        String request = "SELECT * FROM Client";
        Statement statement = laConnexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(request);
        resultSet.last();
        id = resultSet.getInt("id_client");

        dao.delete(dao.getById(id));
        assertNull(dao.getById(id));
    }
}

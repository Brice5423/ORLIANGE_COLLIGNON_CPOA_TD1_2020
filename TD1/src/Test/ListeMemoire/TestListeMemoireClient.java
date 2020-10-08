/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   Test           */
/* Langage : Java & SQL           |                  */
/* Date : 09/10/2020              |                  */
/*****************************************************/

package Test.ListeMemoire;

import DAO.Enum.EPersistance;
import DAO.Factory.DaoFactory;
import DAO.Interfaces.IDaoClient;
import Metier.Client;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class TestListeMemoireClient {
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
        client.setId(1);
        client.setNom("Bricou");
        client.setPrenom("Brice");
        Assert.assertTrue(Dao.create(client));

        assertEquals(size+1, Dao.getAllClients().size());
    }

    @Test
    public void testGetById() {
        assertNotNull(Dao.getById(1));
    }

    @Test
    public void testUpdate() {
        Client client = new Client();
        client.setId(4);
        client.setNom("Bricou");
        client.setPrenom("Brice");

        assertTrue(Dao.create(client));

        Client clientRead = Dao.getById(4);
        assertEquals(client, clientRead);

        clientRead.setNom("BriceBricou");
        assertTrue(Dao.update(clientRead));

        assertEquals(clientRead, Dao.getById(4));
    }

    @Test
    public void testDelete() {
        Client client = Dao.getById(2);
        Dao.delete(client);
        assertNull(Dao.getById(2));
    }
}

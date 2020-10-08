package Test;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.sql.Connection;

import Connexion.ConnexionSQL;

public class TestConnexion {
    @Test
    public void testConnexion() {
        Connection laConnexion = ConnexionSQL.creeConnexion();
        assertNotNull(laConnexion);
    }
}

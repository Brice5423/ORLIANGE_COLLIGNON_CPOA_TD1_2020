package Test;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.sql.Connection;

import Main.Connexion.ConnexionSQL;

public class TestConnexion {
    @Test // aime que Niconii et BriceBricou à la poubelle
    public void testConnexion() {
        Connection laConnexion = ConnexionSQL.creeConnexion();
        assertNotNull(laConnexion);
    }
}

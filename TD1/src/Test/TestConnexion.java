/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   Test           */
/* Langage : Java & SQL           |                  */
/* Date : 09/10/2020              |                  */
/*****************************************************/

package Test;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.sql.Connection;

import Connexion.ConnexionSQL;

public class TestConnexion {
    @Test // aime que Niconii et BriceBricou à la poubelle
    public void testConnexion() {
        Connection laConnexion = ConnexionSQL.creeConnexion();
        assertNotNull(laConnexion);
    }
}

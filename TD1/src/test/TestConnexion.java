package test;


import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import java.sql.Connection;

import home.connexion.ConnexionSQL;


public class TestConnexion {
    @Test // Marche avec Niconii  &  Bricou va se faire ****
    public void testConnexion() {
        Connection laConnexion = ConnexionSQL.creeConnexion();
        assertNotNull(laConnexion);
    }
}

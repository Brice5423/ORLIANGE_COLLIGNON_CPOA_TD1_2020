/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   TD2            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package FactMenu2.MySQL.Produit.Sup;

import Connexion.ConnexionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SupProdSQL {
    public static void supProdSQL(String id_prod) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "DELETE FROM Produit WHERE id_produit = ?";
            PreparedStatement ps = laConnexion.prepareStatement(request);
            ps.setString(1, id_prod);
            ps.executeUpdate();

            laConnexion.close();

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
    }
}

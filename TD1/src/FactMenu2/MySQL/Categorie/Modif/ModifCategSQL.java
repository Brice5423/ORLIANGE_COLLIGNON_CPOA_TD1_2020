/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   ...            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package FactMenu2.MySQL.Categorie.Modif;

import Connexion.ConnexionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModifCategSQL {
    public static void modifCategSQL(String id_cat, String titre_cat, String visuel_cat) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "UPDATE Categorie SET titre = ?, visuel = ? WHERE id_categorie = ?";
            PreparedStatement ps = laConnexion.prepareStatement(request);
            ps.setString(1, titre_cat);
            ps.setString(2, visuel_cat);
            ps.setString(3, id_cat);
            ps.executeUpdate();

            laConnexion.close();

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
    }
}

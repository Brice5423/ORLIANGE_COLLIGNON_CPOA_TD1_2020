/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   ...            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package FactMenu2.MySQL.Categorie.Ajout;

import Connexion.ConnexionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AjoutCategSQL {
    public static void ajoutCategSQL(String titre_cat, String visuel_cat) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "INSERT INTO Categorie(titre, visuel) VALUES(?, ?)";
            PreparedStatement ps = laConnexion.prepareStatement(request);
            ps.setString(1, titre_cat);
            ps.setString(2, visuel_cat);
            ps.executeUpdate();

            laConnexion.close();

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
    }
}

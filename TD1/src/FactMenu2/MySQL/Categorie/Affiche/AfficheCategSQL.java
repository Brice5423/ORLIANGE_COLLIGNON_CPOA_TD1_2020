/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   ...            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package FactMenu2.MySQL.Categorie.Affiche;

import Connexion.ConnexionSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AfficheCategSQL {
    public static void afficheCategSQL() {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "SELECT * FROM Categorie";
            Statement statement = laConnexion.createStatement(); // quand on doir faire des appels reppéter
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                int id = resultSet.getInt("id_categorie");
                String titre = resultSet.getString("titre");
                String visuel = resultSet.getString("visuel");

                System.out.format("%s, %s, %s\n", id, titre, visuel);
            }

            statement.close();
        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
    }
}

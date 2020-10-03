/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   TD2            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package FactMenu2.MySQL.Client.Affiche;

import Connexion.ConnexionSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AfficheClientSQL {
    public static void afficheClientSQL() {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "SELECT * FROM Client";
            Statement statement = laConnexion.createStatement(); // quand on doir faire des appels reppéter
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                int id_client = resultSet.getInt("id_client");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String identifiant = resultSet.getString("identifiant");
                String mdp = resultSet.getString("mot_de_passe");
                String adr_num = resultSet.getString("adr_numero");
                String adr_voie = resultSet.getString("adr_voie");
                String adr_code = resultSet.getString("adr_code_postal");
                String adr_ville = resultSet.getString("adr_ville");
                String adr_pays = resultSet.getString("adr_pays");

                System.out.format("%s, %s, %s, %s, %s, %s, %s, %s, %s, %s\n",
                        id_client, nom, prenom, identifiant, mdp, adr_num, adr_voie, adr_code, adr_ville, adr_pays);
            }

            statement.close();
        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
    }
}

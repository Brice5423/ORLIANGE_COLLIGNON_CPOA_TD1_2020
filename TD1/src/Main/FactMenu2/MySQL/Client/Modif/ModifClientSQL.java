/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   TD2            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package Main.FactMenu2.MySQL.Client.Modif;

import Main.Connexion.ConnexionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModifClientSQL {
    public static void modifClientSQL(String id_client, String nom_client, String prenom_client, String identifiant_client, String mdp_client,
                                      String adr_num_client, String adr_voie_client, String adr_code_client, String adr_ville_client, String adr_pays_client) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "UPDATE Client SET nom = ?, prenom = ?, identifiant = ?, mot_de_passe = ?, adr_numero = ?, " +
                    "adr_voie = ?, adr_code_postal = ?, adr_ville = ?, adr_pays = ? WHERE id_client = ?";
            PreparedStatement ps = laConnexion.prepareStatement(request);
            ps.setString(1, nom_client);
            ps.setString(2, prenom_client);
            ps.setString(3, identifiant_client);
            ps.setString(4, mdp_client);
            ps.setString(5, adr_num_client);
            ps.setString(6, adr_voie_client);
            ps.setString(7, adr_code_client);
            ps.setString(8, adr_ville_client);
            ps.setString(9, adr_pays_client);
            ps.setString(10, id_client);
            ps.executeUpdate();

            laConnexion.close();

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
    }
}
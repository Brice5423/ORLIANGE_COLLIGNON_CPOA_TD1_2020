/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   ...            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package FactMenu2.MySQL.Produit.Modif;

import Connexion.ConnexionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModifProdSQL {
    public static void modifProdSQL(String id_prod, String nom_prod, String description_prod, String tarif_prod, String visuel_prod, String id_categorie) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "UPDATE Produit SET nom = ?, description = ?, tarif = ?, visuel = ?, id_categorie = ? WHERE id_produit = ?";
            PreparedStatement ps = laConnexion.prepareStatement(request);
            ps.setString(1, nom_prod);
            ps.setString(2, description_prod);
            ps.setString(3, tarif_prod);
            ps.setString(4, visuel_prod);
            ps.setString(5, id_categorie);
            ps.setString(6, id_prod);
            ps.executeUpdate();

            laConnexion.close();

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
    }
}

/* *******************************|***************** */
/* Auteur : Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : VSC & Eclipse       |   ...            */
/* Langage : Java                 |                  */
/* Date : 17/09/2020              |                  */
/* *******************************|***************** */

package ClasseSQL;

import java.util.Scanner;
import java.sql.*;

public class Categorie {
    Scanner sc = new Scanner(System.in);

    public void AjoutCategorie() {
        Connection laConnexion = Connexion.creeConnexion();

        String titre_cat = null, visuel_cat = null;

        System.out.println("Donner un titre de la nouvelle Categorie : ");
        titre_cat = sc.next();
        System.out.println("Donner un visuel de la nouvelle Categorie : ");
        visuel_cat = sc.next();

        try {
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


    public void ModifCategorie() {
        Connection laConnexion = Connexion.creeConnexion();

        String id_cat = null, titre_cat = null, visuel_cat = null;

        System.out.println("Donner l'id pour le changement de la Categorie : ");
        id_cat = sc.next();
        System.out.println("Donner un nouveau titre de la Categorie : ");
        titre_cat = sc.next();
        System.out.println("Donner un nouveau visuel de la Categorie : ");
        visuel_cat = sc.next();

        try {
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


    public void SupCategorie() {
        Connection laConnexion = Connexion.creeConnexion();

        String id_cat = null;

        System.out.println("Donner l'id de la categorie a sup : ");
        id_cat = sc.next();

        try {
            String request = "DELETE FROM Categorie WHERE id_categorie = ?";
            PreparedStatement ps = laConnexion.prepareStatement(request);
            ps.setString(1, id_cat);
            ps.executeUpdate();

            laConnexion.close();

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
    }


    public void ArrayList() {
        System.out.println("La fonction ArrayList ne fonctionne pas pour le momment ^^");
        /*try {
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete = laConnexion.createStatement();
            ResultSet res = requete.executeQuery("select no_etudiant, nom_etudiant from etudiant");

            while (res.next()) {
                int no = res.getInt(1);
                String nom = res.getString("nom_etudiant");
            }

            if (res != null)
                res.close();
            if (requete != null)
                requete.close();
            if (laConnexion != null)
                laConnexion.close();

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }*/
    }
}

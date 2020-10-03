/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   TD1            */
/* Langage : Java & SQL           |                  */
/* Date : 17/09/2020              |                  */
/*****************************************************/

package FactMenu1.ClasseSQL;

import Connexion.ConnexionSQL;

import java.util.Scanner;
import java.sql.*;

public class ProduitSQL {
    Scanner sc = new Scanner(System.in);

    public void AjoutProduit() {
        Connection laConnexion = ConnexionSQL.creeConnexion();

        String nom_prod = null, description_prod = null, tarif_prod = null, visuel_prod = null, id_categorie = null;

        System.out.println("Donner un nom au produit : ");
        nom_prod = sc.next();
        System.out.println("Donner une description du produit : ");
        description_prod = sc.next();
        System.out.println("Donner un tarif du produit : ");
        tarif_prod = sc.next();
        System.out.println("Donner le visuel du produit : ");
        visuel_prod = sc.next();
        System.out.println("Donner l'id du type de categorie du produit : ");
        id_categorie = sc.next();

        try {
            String request = "INSERT INTO Produit(nom, description, tarif, visuel, id_categorie) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement ps = laConnexion.prepareStatement(request);
            ps.setString(1, nom_prod);
            ps.setString(2, description_prod);
            ps.setString(3, tarif_prod);
            ps.setString(4, visuel_prod);
            ps.setString(5, id_categorie);
            ps.executeUpdate();

            laConnexion.close();

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
    }


    public void ModifProduit() {
        Connection laConnexion = ConnexionSQL.creeConnexion();

        String id_prod = null, nom_prod = null, description_prod = null, tarif_prod = null, visuel_prod = null, id_categorie = null;

        System.out.println("Donner l'id du produit a modif : ");
        id_prod = sc.next();
        System.out.println("Donner un nom au produit modif : ");
        nom_prod = sc.next();
        System.out.println("Donner une description du produit modif : ");
        description_prod = sc.next();
        System.out.println("Donner un tarif du produit modif : ");
        tarif_prod = sc.next();
        System.out.println("Donner le visuel du produit modif : ");
        visuel_prod = sc.next();
        System.out.println("Donner l'id du type de categorie du produit modif : ");
        id_categorie = sc.next();

        try {
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


    public void SupProduit() {
        Connection laConnexion = ConnexionSQL.creeConnexion();

        String id_prod = null;

        System.out.println("Donner l'id du produit a sup : ");
        id_prod = sc.next();

        try {
            String request = "DELETE FROM Produit WHERE id_produit = ?";
            PreparedStatement ps = laConnexion.prepareStatement(request);
            ps.setString(1, id_prod);
            ps.executeUpdate();

            laConnexion.close();

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
    }


    public void ArrayList() {
        Connection laConnexion = ConnexionSQL.creeConnexion();
        try {
            String request = "SELECT * FROM Produit";
            Statement statement = laConnexion.createStatement(); // quand on doir faire des appels reppéter
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                int id_prod = resultSet.getInt("id_produit");
                String nom = resultSet.getString("nom");
                String description = resultSet.getString("description");
                String tarif = resultSet.getString("tarif");
                String visuel = resultSet.getString("visuel");
                String id_categ = resultSet.getString("id_categorie");

                System.out.format("%s, %s, %s, %s, %s, %s\n", id_prod, nom, description, tarif, visuel, id_categ);
            }

            statement.close();
        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
    }
}

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

public class Produit {
    Scanner sc = new Scanner(System.in);

    public void AjoutProduit() {
        Connection laConnexion = Connexion.creeConnexion();

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
}

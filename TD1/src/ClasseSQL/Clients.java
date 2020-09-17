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

public class Clients {
    public static void AjoutClients() {
        try {
            Connection laConnexion = Connexion.creeConnexion();

            String nom_client, prenom_client, identifiant_client, mdp_client, adr_num_client, adr_voie_client, adr_code_client, adr_ville_client, adr_pays_client;

            final Scanner sc = new Scanner(System.in);
            System.out.println("Donner le nom du client :");
            nom_client = sc.next();
            System.out.println("Donner le prenom du client :");
            prenom_client = sc.next();
            System.out.println("Donner l'identifant du client :");
            identifiant_client = sc.next();
            System.out.println("Donner le mdp du client svp :");
            mdp_client = sc.next();
            System.out.println("Donner le numero de l'adresse du client :");
            adr_num_client = sc.next();
            System.out.println("Donner la voie de l'adresse du client :");
            adr_voie_client = sc.next();
            System.out.println("Donner le code porstal du client :");
            adr_code_client = sc.next();
            System.out.println("Donner le ville du client :");
            adr_ville_client = sc.next();
            System.out.println("Donner le pays du client :");
            adr_pays_client = sc.next();
            sc.close();

            String request = "INSERT INTO Produit(nom, prenom, identifiant, mot_de_passe, adr_numero, adr_voie, adr_code_postal, adr_ville, adr_pays) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            ps.executeUpdate();

            laConnexion.close();

        } catch (SQLException sqle) {
            System.out.println("Pb select" + sqle.getMessage());
        }
    }
}

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
    Scanner sc = new Scanner(System.in);

    public void AjoutClients() {
        Connection laConnexion = Connexion.creeConnexion();

        String nom_client = null, prenom_client = null, identifiant_client = null, mdp_client = null;
        String adr_num_client = null, adr_voie_client = null, adr_code_client = null, adr_ville_client = null, adr_pays_client = null;

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

        try {
            String request = "INSERT INTO Client(nom, prenom, identifiant, mot_de_passe, adr_numero, adr_voie, adr_code_postal, adr_ville, adr_pays) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            System.out.println("Pb select " + sqle.getMessage());
        }
    }


    public void ModifClients() {
        Connection laConnexion = Connexion.creeConnexion();

        String id_client = null, nom_client = null, prenom_client = null, identifiant_client = null, mdp_client = null;
        String adr_num_client = null, adr_voie_client = null, adr_code_client = null, adr_ville_client = null, adr_pays_client = null;

        System.out.println("Donner l'id du client à modif :");
        id_client = sc.next();
        System.out.println("Donner le nom du client à modif :");
        nom_client = sc.next();
        System.out.println("Donner le prenom du client à modif :");
        prenom_client = sc.next();
        System.out.println("Donner l'identifant du client à modif :");
        identifiant_client = sc.next();
        System.out.println("Donner le mdp du client à modif svp :");
        mdp_client = sc.next();
        System.out.println("Donner le numero de l'adresse du client à modif :");
        adr_num_client = sc.next();
        System.out.println("Donner ld rue de l'adresse du client à modif :");
        adr_voie_client = sc.next();
        System.out.println("Donner le code porstal du client à modif :");
        adr_code_client = sc.next();
        System.out.println("Donner le ville du client à modif :");
        adr_ville_client = sc.next();
        System.out.println("Donner le pays du client à modif :");
        adr_pays_client = sc.next();

        try {
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


    public void SupClients() {
        Connection laConnexion = Connexion.creeConnexion();

        String id_client = null;

        System.out.println("Donner l'id de la categorie a sup : ");
        id_client = sc.next();

        try {
            String request = "DELETE FROM Client WHERE id_client = ?";
            PreparedStatement ps = laConnexion.prepareStatement(request);
            ps.setString(1, id_client);
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

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

public class ClientsSQL {
    Scanner sc = new Scanner(System.in);

    public void AjoutClients() {
        Connection laConnexion = ConnexionSQL.creeConnexion();

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
        Connection laConnexion = ConnexionSQL.creeConnexion();

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
        Connection laConnexion = ConnexionSQL.creeConnexion();

        String id_client = null;

        System.out.println("Donner l'id du client a sup : ");
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
        Connection laConnexion = ConnexionSQL.creeConnexion();
        try {
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

/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   DAO            */
/* Langage : Java & SQL           |                  */
/* Date : 07/10/2020              |                  */
/*****************************************************/

package DAO.Memoire;

import Connexion.ConnexionSQL;
import DAO.Interfaces.IDaoClient;
import Metier.Client;

import java.sql.*;
import java.util.List;

public class MySqlClientDao implements IDaoClient {
    private static IDaoClient instance;
    private List<Client> donnees;

    @Override
    public List<Client> getAllClients() {
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

        return null;
    }

    @Override
    public boolean create(Client objet) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "INSERT INTO Client(nom, prenom) VALUES(?, ?)";
            PreparedStatement ps = laConnexion.prepareStatement(request);
            ps.setString(1, objet.getNom());
            ps.setString(2, objet.getPrenom());
            ps.executeUpdate();

            laConnexion.close();
            return false;

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());

            return true;
        }
    }

    /* ************************************************************************************************************** */
    @Override
    public Client getById(int id) {
        /*try {
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
        }*/

        return null;
    }
    /* ************************************************************************************************************** */

    @Override
    public boolean update(Client objet) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "UPDATE Client SET nom = ? WHERE id_client = ?";
            PreparedStatement ps = laConnexion.prepareStatement(request);
            ps.setString(1, objet.getNom());
            ps.setString(2, objet.getPrenom());
            ps.executeUpdate();

            laConnexion.close();
            return true;

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());

            return false;
        }
    }

    @Override
    public boolean delete(Client objet) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "DELETE FROM Client WHERE id_client = ?";
            PreparedStatement ps = laConnexion.prepareStatement(request);
            ps.setInt(1, objet.getId());
            ps.executeUpdate();

            laConnexion.close();
            return true;

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());

            return false;
        }
    }
}

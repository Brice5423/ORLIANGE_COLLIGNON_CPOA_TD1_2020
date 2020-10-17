package dao.mysql;

import home.connexion.ConnexionSQL;
import dao.interfaces.IDaoClient;
import home.metier.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlClientDao implements IDaoClient {
    private static IDaoClient instance;
    private List<Client> donnees;

    public static IDaoClient getInstance() {
        if (instance == null) {
            instance = new MySqlClientDao();
        }
        return instance;
    }

    private MySqlClientDao() {
        // Pour éviter instanciation directe :
        this.donnees = new ArrayList<Client>();
    }

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

                System.out.format("%s, %s, %s\n", id_client, nom, prenom);

                Client client = new Client(id_client, nom, prenom);
                donnees.add(client);
            }

            statement.close();
            return donnees;

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
            return true;

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
        return false;
    }

    /* ************************************************************************************************************** */
    @Override
    public Client getById(int id) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "SELECT * FROM Client";
            Statement statement = laConnexion.createStatement(); // quand on doir faire des appels reppéter
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                int id_client = resultSet.getInt("id_client");
                if(id_client == id) {
                    String nom = resultSet.getString("nom");
                    String prenom = resultSet.getString("prenom");

                    System.out.format("%s, %s, %s\n", id_client, nom, prenom);

                    Client client = new Client(id_client, nom, prenom);
                    statement.close();
                    return client;
                }
            }
        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
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
        }
        return false;
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
        }
        return false;
    }
}

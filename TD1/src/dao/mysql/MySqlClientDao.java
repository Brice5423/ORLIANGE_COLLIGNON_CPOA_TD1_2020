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
                int idClient = resultSet.getInt("id_client");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String mail = resultSet.getString("identifiant");
                String mdp = resultSet.getString("mot_de_passe");

                String adrNum = resultSet.getString("adr_numero");
                String adrVoie = resultSet.getString("adr_voie");
                String adrCodePostal = resultSet.getString("adr_code_postal");
                String adrVille = resultSet.getString("adr_ville");
                String adrPays = resultSet.getString("adr_pays");

                System.out.format("%s, %s, %s\n", idClient, nom, prenom);

                Client client = new Client(idClient, nom, prenom, mail, mdp, adrNum, adrVoie, adrCodePostal, adrVille, adrPays);
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

            String request = "INSERT INTO Client(nom, prenom, identifiant, mot_de_passe, adr_numero, adr_voie, adr_code_postal, adr_ville, adr_pays) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = laConnexion.prepareStatement(request);

            ps.setString(1, objet.getNom());
            ps.setString(2, objet.getPrenom());
            ps.setString(3, objet.getMail());
            ps.setString(4, objet.getMdp());

            ps.setString(5, objet.getAdrNum());
            ps.setString(6, objet.getAdrVoie());
            ps.setString(7, objet.getAdrCodePostal());
            ps.setString(8, objet.getAdrVille());
            ps.setString(9, objet.getAdrPays());

            ps.executeUpdate();

            laConnexion.close();
            return true;

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
        return false;
    }

    @Override
    public Client getById(int id) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "SELECT * FROM Client";
            Statement statement = laConnexion.createStatement(); // quand on doir faire des appels reppéter
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                int idClient = resultSet.getInt("id_client");
                if(idClient == id) {
                    String nom = resultSet.getString("nom");
                    String prenom = resultSet.getString("prenom");
                    String mail = resultSet.getString("identifiant");
                    String mdp = resultSet.getString("mot_de_passe");

                    String adrNum = resultSet.getString("adr_numero");
                    String adrVoie = resultSet.getString("adr_voie");
                    String adrCodePostal = resultSet.getString("adr_code_postal");
                    String adrVille = resultSet.getString("adr_ville");
                    String adrPays = resultSet.getString("adr_pays");

                    System.out.format("%s, %s, %s\n", idClient, nom, prenom);

                    Client client = new Client(idClient, nom, prenom, mail, mdp, adrNum, adrVoie, adrCodePostal, adrVille, adrPays);
                    statement.close();
                    return client;
                }
            }
        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
        return null;
    }

    @Override
    public boolean update(Client objet) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "UPDATE Client SET nom = ? AND prenom = ? AND identifiant = ? AND mot_de_passe = ? AND adr_numero = ? AND adr_voie = ? AND adr_code_postal = ? AND adr_ville = ? AND adr_pays = ? WHERE id_client = ?";
            PreparedStatement ps = laConnexion.prepareStatement(request);

            ps.setString(1, objet.getNom());
            ps.setString(2, objet.getPrenom());
            ps.setString(3, objet.getMail());
            ps.setString(4, objet.getMdp());

            ps.setString(5, objet.getAdrNum());
            ps.setString(6, objet.getAdrVoie());
            ps.setString(7, objet.getAdrCodePostal());
            ps.setString(8, objet.getAdrVille());
            ps.setString(9, objet.getAdrPays());

            ps.setInt(10, objet.getId());
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

    public List<Client> getByNomPrenom(String filtreNom, String filtrePrenom) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "SELECT * FROM Client";
            Statement statement = laConnexion.createStatement(); // quand on doir faire des appels reppéter
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                String testNom = resultSet.getString("nom");
                String testPrenom = resultSet.getString("prenom");

                if (((filtreNom==testNom) && (filtrePrenom=="")) || ((filtreNom==testNom) && (filtrePrenom==testPrenom))) {
                    int idClient = resultSet.getInt("id_client");
                    String nom = resultSet.getString("nom");
                    String prenom = resultSet.getString("prenom");
                    String mail = resultSet.getString("identifiant");
                    String mdp = resultSet.getString("mot_de_passe");

                    String adrNum = resultSet.getString("adr_numero");
                    String adrVoie = resultSet.getString("adr_voie");
                    String adrCodePostal = resultSet.getString("adr_code_postal");
                    String adrVille = resultSet.getString("adr_ville");
                    String adrPays = resultSet.getString("adr_pays");

                    System.out.format("%s, %s, %s\n", idClient, nom, prenom);

                    Client client = new Client(idClient, nom, prenom, mail, mdp, adrNum, adrVoie, adrCodePostal, adrVille, adrPays);
                    donnees.add(client);
                }
            }

            statement.close();
            return donnees;

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
        return null;
    }
}

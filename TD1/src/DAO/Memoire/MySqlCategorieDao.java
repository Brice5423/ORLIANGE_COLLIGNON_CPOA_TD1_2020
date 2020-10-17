package DAO.Memoire;

import Main.Connexion.ConnexionSQL;
import DAO.Interfaces.IDaoCategorie;
import Main.Metier.Categorie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlCategorieDao implements IDaoCategorie {
    private static IDaoCategorie instance;
    private List<Categorie> donnees;

    public static IDaoCategorie getInstance() {
        if (instance == null) {
            instance = new MySqlCategorieDao();
        }
        return instance;
    }

    private MySqlCategorieDao() {
        // Pour éviter instanciation directe :
        this.donnees = new ArrayList<Categorie>();
    }

    @Override
    public List<Categorie> getAllCategories() {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "SELECT * FROM Categorie";
            Statement statement = laConnexion.createStatement(); // quand on doir faire des appels reppéter
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                int id = resultSet.getInt("id_categorie");
                String titre = resultSet.getString("titre");
                String visuel = resultSet.getString("visuel");

                System.out.format("%s, %s, %s\n", id, titre, visuel);

                Categorie categorie = new Categorie(id, titre, visuel);
                donnees.add(categorie);
            }

            statement.close();
            return donnees;

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
        return null;
    }

    @Override
    public boolean create(Categorie objet) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "INSERT INTO Categorie(titre, visuel) VALUES(?, ?)";
            PreparedStatement ps = laConnexion.prepareStatement(request);
            ps.setString(1, objet.getTitre());
            ps.setString(2, objet.getVisuel());
            ps.executeUpdate();

            laConnexion.close();
            return true;

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());

            return false;
        }
    }

    /* ************************************************************************************************************** */
    @Override
    public Categorie getById(int id) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "SELECT * FROM Categorie";
            Statement statement = laConnexion.createStatement(); // quand on doir faire des appels reppéter
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                int id_categorie = resultSet.getInt("id_categorie");
                if(id_categorie == id) {
                    String titre = resultSet.getString("titre");
                    String visuel = resultSet.getString("visuel");

                    System.out.format("%s, %s, %s\n", id_categorie, titre, visuel);

                    Categorie categorie = new Categorie(id_categorie, titre, visuel);
                    statement.close();
                    return categorie;
                }
            }
        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
        return null;
    }
    /* ************************************************************************************************************** */

    @Override
    public boolean update(Categorie objet) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "UPDATE Categorie SET titre = ?, visuel = ? WHERE id_categorie = ?";
            PreparedStatement ps = laConnexion.prepareStatement(request);
            ps.setString(1, objet.getTitre());
            ps.setString(2, objet.getVisuel());
            ps.setInt(3, objet.getId());
            ps.executeUpdate();

            laConnexion.close();
            return true;

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());

            return false;
        }
    }

    @Override
    public boolean delete(Categorie objet) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "DELETE FROM Categorie WHERE id_categorie = ?";
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

package dao.mysql;

import home.connexion.ConnexionSQL;
import dao.interfaces.IDaoProduit;
import home.metier.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlProduitDao implements IDaoProduit  {
    private static IDaoProduit instance;
    private List<Produit> donnees;

    public static IDaoProduit getInstance() {
        if (instance == null) {
            instance = new MySqlProduitDao();
        }
        return instance;
    }

    private MySqlProduitDao() {
        // Pour éviter instanciation directe :
        this.donnees = new ArrayList<Produit>();
    }

    @Override
    public List<Produit> getAllProduits() {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "SELECT * FROM Produit";
            Statement statement = laConnexion.createStatement(); // quand on doir faire des appels reppéter
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                int id_prod = resultSet.getInt("id_produit");
                String nom = resultSet.getString("nom");
                String description = resultSet.getString("description");
                double tarif = resultSet.getFloat("tarif");
                String visuel = resultSet.getString("visuel");
                int id_categ = resultSet.getInt("id_categorie");

                Produit produit = new Produit(id_prod, nom, description, tarif, visuel, MySqlCategorieDao.getInstance().getById(id_categ));
                donnees.add(produit);
            }

            statement.close();
            return donnees;

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
        return null;
    }

    @Override
    public boolean create(Produit objet) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "INSERT INTO Produit(nom, description, tarif, visuel, id_categorie) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement ps = laConnexion.prepareStatement(request);
            ps.setString(1, objet.getNom());
            ps.setString(2, objet.getDescription());
            ps.setDouble(3, objet.getTarif());
            ps.setString(4, objet.getVisuel());
            ps.setInt(5, objet.getCategorie().getId());
            ps.executeUpdate();

            laConnexion.close();
            return true;

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
        return false;
    }

    @Override
    public Produit getById(int id) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "SELECT * FROM Produit";
            Statement statement = laConnexion.createStatement(); // quand on doir faire des appels reppéter
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                int id_prod = resultSet.getInt("id_produit");
                if(id_prod == id) {
                    String nom = resultSet.getString("nom");
                    String description = resultSet.getString("description");
                    double tarif = resultSet.getDouble("tarif");
                    String visuel = resultSet.getString("visuel");
                    int id_categ = resultSet.getInt("id_categorie");

                    System.out.format("%s, %s, %s, %s, %s, %s\n", id_prod, nom, description, tarif, visuel, id_categ);

                    Produit produit = new Produit(id_prod, nom, description, tarif, visuel, MySqlCategorieDao.getInstance().getById(id_categ));
                    statement.close();
                    return produit;
                }
            }
        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
        return null;
    }

    @Override
    public boolean update(Produit objet) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "UPDATE Produit SET nom = ?, description = ?, tarif = ?, visuel = ?, id_categorie = ? WHERE id_produit = ?";
            PreparedStatement ps = laConnexion.prepareStatement(request);
            ps.setString(1, objet.getNom());
            ps.setString(2, objet.getDescription());
            ps.setDouble(3, objet.getTarif());
            ps.setString(4, objet.getVisuel());
            ps.setInt(5, objet.getCategorie().getId());
            ps.setInt(6, objet.getId());
            ps.executeUpdate();

            laConnexion.close();
            return true;

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Produit objet) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "DELETE FROM Produit WHERE id_produit = ?";
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

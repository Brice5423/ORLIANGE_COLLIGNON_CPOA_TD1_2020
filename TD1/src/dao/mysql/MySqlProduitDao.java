package dao.mysql;


import home.connexion.ConnexionSQL;
import home.metier.Categorie;
import home.metier.Produit;

import dao.interfaces.IDaoProduit;

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


    @Override // Lire tout
    public List<Produit> getAllProduits() {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "SELECT * FROM Produit";
            Statement statement = laConnexion.createStatement(); // quand on doir faire des appels reppéter
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                int idProd = resultSet.getInt("id_produit");
                String nom = resultSet.getString("nom");
                String description = resultSet.getString("description");
                double tarif = resultSet.getFloat("tarif");
                String visuel = resultSet.getString("visuel");
                int idCateg = resultSet.getInt("id_categorie");

                Produit produit = new Produit(idProd, nom, description, tarif, visuel, MySqlCategorieDao.getInstance().getById(idCateg));
                donnees.add(produit);
            }

            statement.close();
            return donnees;

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
        return null;
    }


    @Override // Filtre par Categorie
    public List<Produit> getByCategorie(Categorie filtreCategorie) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "SELECT * FROM Produit";
            Statement statement = laConnexion.createStatement(); // quand on doir faire des appels reppéter
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                int idCateg = resultSet.getInt("id_categorie");
                Categorie testCategorie = MySqlCategorieDao.getInstance().getById(idCateg);

                if (testCategorie.getId() == filtreCategorie.getId()) {
                    int idProd = resultSet.getInt("id_produit");
                    String nom = resultSet.getString("nom");
                    String description = resultSet.getString("description");
                    double tarif = resultSet.getFloat("tarif");
                    String visuel = resultSet.getString("visuel");

                    Produit produit = new Produit(idProd, nom, description, tarif, visuel, testCategorie);
                    donnees.add(produit);
                }
            }

            statement.close();
            return donnees;

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
        return null;
    }

    @Override // Filtre par Nom du Produit
    public List<Produit> getByNomProduit(String filtreNomProduit) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "SELECT * FROM Produit";
            Statement statement = laConnexion.createStatement(); // quand on doir faire des appels reppéter
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                String nom = resultSet.getString("nom");

                if (nom == filtreNomProduit) {
                    int idProd = resultSet.getInt("id_produit");
                    String description = resultSet.getString("description");
                    double tarif = resultSet.getFloat("tarif");
                    String visuel = resultSet.getString("visuel");
                    int idCateg = resultSet.getInt("id_categorie");

                    Produit produit = new Produit(idProd, nom, description, tarif, visuel, MySqlCategorieDao.getInstance().getById(idCateg));
                    donnees.add(produit);
                }
            }

            statement.close();
            return donnees;

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
        return null;
    }

    @Override // Filtre par Tarif ( < filtreTarif )
    public List<Produit> getByTarif(Double filtreTarif) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "SELECT * FROM Produit";
            Statement statement = laConnexion.createStatement(); // quand on doir faire des appels reppéter
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                double tarif = resultSet.getFloat("tarif");

                if (tarif <= filtreTarif) {
                    int idProd = resultSet.getInt("id_produit");
                    String nom = resultSet.getString("nom");
                    String description = resultSet.getString("description");
                    String visuel = resultSet.getString("visuel");
                    int idCateg = resultSet.getInt("id_categorie");

                    Produit produit = new Produit(idProd, nom, description, tarif, visuel, MySqlCategorieDao.getInstance().getById(idCateg));
                    donnees.add(produit);
                }
            }

            statement.close();
            return donnees;

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
        return null;
    }


    @Override // Cree
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

    @Override // Lire
    public Produit getById(int id) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "SELECT * FROM Produit";
            Statement statement = laConnexion.createStatement(); // quand on doir faire des appels reppéter
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                int idProd = resultSet.getInt("id_produit");
                if(idProd == id) {
                    String nom = resultSet.getString("nom");
                    String description = resultSet.getString("description");
                    double tarif = resultSet.getDouble("tarif");
                    String visuel = resultSet.getString("visuel");
                    int idCateg = resultSet.getInt("id_categorie");

                    System.out.format("%s, %s, %s, %s, %s, %s\n", idProd, nom, description, tarif, visuel, idCateg);

                    Produit produit = new Produit(idProd, nom, description, tarif, visuel, MySqlCategorieDao.getInstance().getById(idCateg));
                    statement.close();
                    return produit;
                }
            }
        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
        return null;
    }

    @Override // Modif
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

    @Override // Sup
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

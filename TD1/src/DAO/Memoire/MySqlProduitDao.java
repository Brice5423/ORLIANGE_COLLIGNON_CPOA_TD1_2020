/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   DAO            */
/* Langage : Java & SQL           |                  */
/* Date : 07/10/2020              |                  */
/*****************************************************/

package DAO.Memoire;

import Connexion.ConnexionSQL;
import DAO.Interfaces.IDaoProduit;
import Metier.Produit;

import java.sql.*;
import java.util.List;

public class MySqlProduitDao implements IDaoProduit  {
    private static IDaoProduit instance;
    private List<Produit> produits;

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
                String tarif = resultSet.getString("tarif");
                String visuel = resultSet.getString("visuel");
                String id_categ = resultSet.getString("id_categorie");

                System.out.format("%s, %s, %s, %s, %s, %s\n", id_prod, nom, description, tarif, visuel, id_categ);
            }

            statement.close();
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
            ps.setString(5, "objet.getCategorie()"); // problème de type Produit
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
    public Produit getById(int id) {
        /*try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "SELECT * FROM Produit";
            Statement statement = laConnexion.createStatement(); // quand on doir faire des appels reppéter
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                int id_prod = resultSet.getInt("id_produit");
                String nom = resultSet.getString("nom");
                String description = resultSet.getString("description");
                String tarif = resultSet.getString("tarif");
                String visuel = resultSet.getString("visuel");
                String id_categ = resultSet.getString("id_categorie");

                System.out.format("%s, %s, %s, %s, %s, %s\n", id_prod, nom, description, tarif, visuel, id_categ);
            }

            statement.close();
        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }*/

        return null;
    }
    /* ************************************************************************************************************** */

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
            ps.setString(5, "objet.getCategorie()"); // problème de type Produit
            ps.setInt(6, objet.getId());
            ps.executeUpdate();

            laConnexion.close();
            return true;

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());

            return false;
        }
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

            return false;
        }
    }
}

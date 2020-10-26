package dao.mysql;

import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import dao.interfaces.IDaoCommande;
import dao.interfaces.IDaoProduit;

import home.connexion.ConnexionSQL;
import home.metier.Commande;
import home.metier.Produit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.*;

public class MySqlCommandeDao implements IDaoCommande {
    private static IDaoCommande instance;
    private List<Commande> donnees;

    public static IDaoCommande getInstance() {
        if (instance == null) {
            instance = new MySqlCommandeDao();
        }
        return instance;
    }

    private MySqlCommandeDao() {
        // Pour éviter instanciation directe :
        this.donnees = new ArrayList<Commande>();
    }


    @Override
    public List<Commande> getAllCommande() {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "SELECT * FROM Commande";
            Statement statement = laConnexion.createStatement(); // quand on doir faire des appels reppéter
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                int id_commande = resultSet.getInt("id_commande");
                Date date = resultSet.getDate("date_commande");
                int id_client = resultSet.getInt("id_client");

                // Gestion du la map produit dans la ligne commande //
                String request_LC = "SELECT * FROM Ligne_commande";
                Statement statement_LC = laConnexion.createStatement(); // quand on doir faire des appels reppéter
                ResultSet resultSet_LC = statement_LC.executeQuery(request_LC);

                Map<Produit, Integer> produits = new HashMap<>();

                while (resultSet_LC.next()) {
                    if (resultSet_LC.getInt(id_commande) == id_commande) {
                        int id_produit_LC = resultSet_LC.getInt("id_produit");
                        int quantite_LC = resultSet_LC.getInt("quantite");

                        IDaoProduit daoproduit = DaoFactory.getDAOFactory(EPersistance.MYSQL).getDaoProduit();
                        Produit produit = daoproduit.getById(id_produit_LC);
                        produits.put(produit, quantite_LC);
                    }
                }

                Commande commande = new Commande(id_commande, date, MySqlClientDao.getInstance().getById(id_client), produits);
                statement_LC.close();
                donnees.add(commande);
            }

            statement.close();
            return donnees;

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
        return null;
    }

    @Override
    public boolean create(Commande objet) {
        return false;
    }

    @Override
    public Commande getById(int id) {
        return null;
    }

    @Override
    public boolean update(Commande objet) {
        return false;
    }

    @Override
    public boolean delete(Commande objet) {
        return false;
    }
}

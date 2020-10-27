package dao.mysql;

import dao.enumeration.EPersistance;
import dao.factory.DaoFactory;
import dao.interfaces.IDaoClient;
import dao.interfaces.IDaoCommande;
import dao.interfaces.IDaoProduit;

import home.connexion.ConnexionSQL;
import home.metier.Client;
import home.metier.Commande;
import home.metier.Produit;

import java.sql.*;

import java.util.*;
import java.util.Date;

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

                // Gestion du la map produit dans la ligne commande / Recupe tous les produits commandes en fonction du client //
                String request_LC = "SELECT * FROM Ligne_commande";
                Statement statement_LC = laConnexion.createStatement(); // quand on doir faire des appels reppéter
                ResultSet resultSet_LC = statement_LC.executeQuery(request_LC);

                Map<Produit, Integer> produits = new HashMap<>();

                while (resultSet_LC.next()) { // fait derouler tout le tableau ligne_commande
                    if (resultSet_LC.getInt(id_commande) == id_commande) { // regarde si id_commande du tableau commande est egal à id_commande du tableau Commande
                        if (produits.isEmpty()) { // mes le 1er produit dans la liste sans verif
                            int id_produit_LC = resultSet_LC.getInt("id_produit");
                            int quantite_LC = resultSet_LC.getInt("quantite");

                            IDaoProduit daoProduit = DaoFactory.getDAOFactory(EPersistance.MYSQL).getDaoProduit();
                            Produit produit_LC = daoProduit.getById(id_produit_LC);

                            produits.put(produit_LC, quantite_LC);
                        } else {
                            for (Map.Entry<Produit, Integer> produit : produits.entrySet()) { // fait dérouler la hashMap
                                if (produit.getKey().getId() == resultSet_LC.getInt("id_produit")) { // verifi si le produit est dans la hashMap
                                    continue; // ne fait rien
                                } else {
                                    int id_produit_LC = resultSet_LC.getInt("id_produit");
                                    int quantite_LC = resultSet_LC.getInt("quantite");

                                    IDaoProduit daoProduit = DaoFactory.getDAOFactory(EPersistance.MYSQL).getDaoProduit();
                                    Produit produit_LC = daoProduit.getById(id_produit_LC);

                                    produits.put(produit_LC, quantite_LC);
                                }
                            }
                        }
                    }
                }

                Commande commande = new Commande(id_commande, date, MySqlClientDao.getInstance().getById(id_client), produits);
                donnees.add(commande);
                statement_LC.close();
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
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String requestCommande = "INSERT INTO Commande(date_commande, id_client) VALUES(?, ?)";
            PreparedStatement ajoutCommande = laConnexion.prepareStatement(requestCommande);
            ajoutCommande.setDate(1, (java.sql.Date) objet.getDate());
            ajoutCommande.setInt(2, objet.getClient().getId());
            ajoutCommande.executeUpdate();

            Map<Produit, Integer> produits = objet.getProduits();

            // Création de tout les ligne de commande dans la table Ligne_commande //
            for (Map.Entry<Produit, Integer> produit : produits.entrySet()) {
                String requestLigneCommande = "INSERT INTRO Ligne_commande(id_commande, id_produit, quantite, tarif_unitaire) VALUES(?, ?, ?, ?)";
                PreparedStatement ajoutLigneCommande = laConnexion.prepareStatement(requestLigneCommande);
                ajoutLigneCommande.setInt(1, 1); // a voir comment faire
                ajoutLigneCommande.setInt(2, produit.getKey().getId());
                ajoutLigneCommande.setInt(3, produit.getValue());
                ajoutLigneCommande.setDouble(4, produit.getKey().getTarif());
                ajoutLigneCommande.executeUpdate();
            }

            laConnexion.close();
            return true;

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
        return false;
    }

    @Override
    public Commande getById(int id) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "SELECT * FROM Commande";
            Statement statement = laConnexion.createStatement(); // quand on doir faire des appels reppéter
            ResultSet resultSet = statement.executeQuery(request);

            while (resultSet.next()) {
                int id_commande = resultSet.getInt("id_produit");

                if(id_commande == id) {
                    Date date = resultSet.getDate("date_commande");
                    int id_client = resultSet.getInt("id_client");

                    // Recup tout les infos du client de la commande //
                    IDaoClient daoClient = DaoFactory.getDAOFactory(EPersistance.MYSQL).getDaoClient();
                    Client client = daoClient.getById(id_client);

                    // Recuper tout les produits commander avec la quantité //
                    String request_LC = "SELECT * FROM Commande";
                    Statement statement_LC = laConnexion.createStatement(); // quand on doir faire des appels reppéter
                    ResultSet resultSet_LC = statement_LC.executeQuery(request_LC);

                    Map<Produit, Integer> produits = new HashMap<>();

                    while (resultSet_LC.next()) { // fait derouler tout le tableau ligne_commande
                        if (resultSet_LC.getInt(id_commande) == id_commande) { // regarde si id_commande du tableau commande est egal à id_commande du tableau Commande
                            if (produits.isEmpty()) { // mes le 1er produit dans la liste sans verif
                                int id_produit_LC = resultSet_LC.getInt("id_produit");
                                int quantite_LC = resultSet_LC.getInt("quantite");

                                IDaoProduit daoProduit = DaoFactory.getDAOFactory(EPersistance.MYSQL).getDaoProduit();
                                Produit produit_LC = daoProduit.getById(id_produit_LC);

                                produits.put(produit_LC, quantite_LC);
                            } else {
                                for (Map.Entry<Produit, Integer> produit : produits.entrySet()) { // fait dérouler la hashMap
                                    if (produit.getKey().getId() == resultSet_LC.getInt("id_produit")) { // verifi si le produit est dans la hashMap
                                        continue; // ne fait rien
                                    } else {
                                        int id_produit_LC = resultSet_LC.getInt("id_produit");
                                        int quantite_LC = resultSet_LC.getInt("quantite");

                                        IDaoProduit daoProduit = DaoFactory.getDAOFactory(EPersistance.MYSQL).getDaoProduit();
                                        Produit produit_LC = daoProduit.getById(id_produit_LC);

                                        produits.put(produit_LC, quantite_LC);
                                    }
                                }
                            }
                        }
                    }

                    Commande commande = new Commande(id_commande, date, client, produits);
                    statement_LC.close();
                    statement.close();
                    return commande;
                }
            }
        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
        return null;
    }

    @Override
    public boolean update(Commande objet) {
        try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String requestCommande = "UPDATE Commande SET date_commande = ?, id_client = ? WHERE id_commande = ?";
            PreparedStatement modifCommande = laConnexion.prepareStatement(requestCommande);
            modifCommande.setDate(1, (java.sql.Date) objet.getDate());
            modifCommande.setInt(2, objet.getClient().getId());
            modifCommande.setInt(3, objet.getId());
            modifCommande.executeUpdate();

            Map<Produit, Integer> produits = objet.getProduits();

            // Création de tout les ligne de commande dans la table Ligne_commande //
            for (Map.Entry<Produit, Integer> produit : produits.entrySet()) {
                String requestLigneCommande = "UPDATE Ligne_commande SET quantite = ?, tarif_unitaire = ? WHERE id_commande = ? AND id_produit = ?";
                PreparedStatement modifLigneCommande = laConnexion.prepareStatement(requestLigneCommande);
                modifLigneCommande.setInt(1, produit.getValue()); // quantite
                modifLigneCommande.setDouble(2, produit.getKey().getTarif()); // tarif_unitaire
                modifLigneCommande.setInt(3, objet.getId()); // id_commande
                modifLigneCommande.setInt(4, produit.getKey().getId()); // id_produit
                modifLigneCommande.executeUpdate();
            }

            laConnexion.close();
            return true;

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Commande objet) {
        /*try {
            Connection laConnexion = ConnexionSQL.creeConnexion();

            String request = "DELETE FROM Produit WHERE id_produit = ?";
            PreparedStatement ps = laConnexion.prepareStatement(request);
            ps.setInt(1, objet.getId());
            ps.executeUpdate();

            laConnexion.close();
            return true;

        } catch (SQLException sqle) {
            System.out.println("Pb select " + sqle.getMessage());
        }*/
        return false;
    }
}
